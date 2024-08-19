package za.co.wethinkcode.persist;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.jdbc.JdbcConnectionSource;

import za.co.wethinkcode.persist.orm.ProductDAO;
import za.co.wethinkcode.persist.orm.ProductDO;

public class RecipeDbDemo {
    private static final String DATABASE_URL = "jdbc:sqlite:products.db";
    private ProductDAO productDao;

    public RecipeDbDemo() throws SQLException {
        JdbcConnectionSource connectionSource = new JdbcConnectionSource(DATABASE_URL);
        productDao = new ProductDAO(connectionSource);
    }

    public static void main(String[] args) {
        try {
            RecipeDbDemo app = new RecipeDbDemo();
            app.run();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void run() throws SQLException {
        displayAllProducts();
    }

    private void displayAllProducts() throws SQLException {
        List<ProductDO> products = productDao.getAllProducts();

        for (ProductDO p : products) {
            System.out.println(p.getId() + " " + p.getName() + " " + p.getStyleName());
        }
    }
}