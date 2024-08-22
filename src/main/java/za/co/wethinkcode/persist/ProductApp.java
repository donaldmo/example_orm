package za.co.wethinkcode.persist;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.jdbc.JdbcConnectionSource;

import io.javalin.Javalin;
import io.javalin.http.Context;
import za.co.wethinkcode.persist.orm.DbConnector;
import za.co.wethinkcode.persist.orm.ProductDAO;
import za.co.wethinkcode.persist.orm.ProductDO;

public class ProductApp {
    private static ProductDAO productDAO;
    private static DbConnector dbConnector;

    public ProductApp() throws SQLException {
        String DATABASE_URL = "jdbc:sqlite:products_database.db";
        dbConnector = new DbConnector(DATABASE_URL);

        try {
            Connection connection = dbConnector.connect();
            dbConnector.createProductsTable(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }

        JdbcConnectionSource connectionSource = new JdbcConnectionSource(DATABASE_URL);
        productDAO = new ProductDAO(connectionSource);
    }

    public static void main(String[] args) {
        try {
            ProductApp app = new ProductApp();
            app.run();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void run() throws SQLException {
        Javalin app = Javalin.create().start(7000);

        app.post("/products", ProductApp::handlePostProduct);
        app.get("/products", ProductApp::handleGetProduct);
        app.get("/products/{id}", ProductApp::handleGetProductById);
    }

    private static void handleGetProduct(Context ctx) {
        try {
            List<ProductDO> products = productDAO.getAllProducts();
            ctx.json(products);
        } catch (SQLException e) {
            ctx.status(500).result("Error retrieving products: " + e.getMessage());
        }
    }

    private static void handlePostProduct(Context ctx) {
        try {
            ProductDO prodcuct = ctx.bodyAsClass(ProductDO.class);
            productDAO.addProduct(prodcuct);
            ctx.status(201).json(prodcuct);
        } catch (Exception e) {
            ctx.status(500).result("Error adding product: " + e.getMessage());
        }
    }

    private static void handleGetProductById(Context ctx) {
        try {
            int productId = Integer.parseInt(ctx.pathParam("id"));
            ProductDO product = productDAO.getProduct(productId);

            if (product != null) {
                ctx.json(product);
            } else {
                ctx.status(404).result("Product not found");
            }
        } catch (NumberFormatException e) {
            ctx.status(400).result("Invalid product ID format");
        } catch (SQLException e) {
            ctx.status(500).result("Error retrieving product: " + e.getMessage());
        }
    }
}