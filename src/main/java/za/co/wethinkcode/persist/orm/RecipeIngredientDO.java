package za.co.wethinkcode.persist.orm;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "recipe_ingredients")
public class RecipeIngredientDO {
    @DatabaseField
    public int productId;

    @DatabaseField
    public String productName;

    @DatabaseField
    public int ingredientId;

    @DatabaseField
    public String ingredientName;

    @DatabaseField
    public String ingredientType;

    @DatabaseField
    public int qty;

    @DatabaseField
    public String units;

    public RecipeIngredientDO() {
    }

    // Getters and Setters
    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public String getIngredientType() {
        return ingredientType;
    }

    public void setIngredientType(String ingredientType) {
        this.ingredientType = ingredientType;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }
}
