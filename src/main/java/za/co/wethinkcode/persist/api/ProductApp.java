package za.co.wethinkcode.persist.api;

import io.javalin.Javalin;
import io.javalin.http.Context;
import za.co.wethinkcode.persist.orm.ProductDAO;
import za.co.wethinkcode.persist.orm.ProductDO;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class ProductApp {
    private static ProductDAO productDAO;

    public static void main(String args) throws Exception {

        String DATABASE_URL = "jdbc:sqlite:products.db";
        JdbcConnectionSource connectionSource = new JdbcConnectionSource(DATABASE_URL);

        // Create the table if it doesn't exist
        TableUtils.createTableIfNotExists(connectionSource, ProductDO.class);
        // productDAO = new ProductDAO(connectionSource);

        Javalin app = Javalin.create().start(7000);

        app.post("/products", ProductApp::handlePostProduct);
    }

    private static void handlePostProduct(Context ctx) {
        try {
            ProductDO prodcuct = ctx.bodyAsClass(ProductDO.class);

            // Add the product to the database
            productDAO.addProduct(prodcuct);

            // Response with the created product's details
            ctx.status(201).json(prodcuct);
        } catch (Exception e) {
            ctx.status(500).result("Error adding product: " + e.getMessage());
        }
    }
}
