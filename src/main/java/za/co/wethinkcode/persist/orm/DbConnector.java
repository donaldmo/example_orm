package za.co.wethinkcode.persist.orm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnector {
    private String url;

    public DbConnector(String url) {
        this.url = url;
    }

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void disconnect(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Connection to SQLite has been closed.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createProductsTable(Connection connection) {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS products (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL," +
                "styleName TEXT);";

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createTableSQL);
            System.out.println("Products table has been created.");
        } catch (Exception e) {
            System.out.println("Error creating products table: " + e.getMessage());
        }
    }
}
