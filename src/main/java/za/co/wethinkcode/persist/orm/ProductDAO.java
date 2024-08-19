package za.co.wethinkcode.persist.orm;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;

public class ProductDAO {
    private Dao<ProductDO, Integer> productDao;

    public ProductDAO(JdbcConnectionSource connectionSource) throws SQLException {
        productDao = DaoManager.createDao(connectionSource, ProductDO.class);
    }

    public List<ProductDO> getAllProducts() throws SQLException {
        return productDao.queryForAll();
    }

    public ProductDO getProduct(int productId) throws SQLException {
        return productDao.queryForId(productId);
    }

    public void addProduct(ProductDO product) throws SQLException {
        productDao.create(product);
    }

    public void updateProductName(int productId, String newName) throws SQLException {
        ProductDO product = productDao.queryForId(productId);

        if (product != null) {
            product.setName(newName);
            productDao.update(product);
        }
    }

    public long getNumberOfProducts() throws SQLException {
        return productDao.countOf();
    }
}