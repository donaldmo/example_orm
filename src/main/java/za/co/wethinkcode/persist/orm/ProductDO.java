package za.co.wethinkcode.persist.orm;

// import net.lemnik.eodsql.ResultColumn;

/**
 * TODO: javadoc ProductDO
 */
public class ProductDO {
    private int id;
    private String name;
    private String styleName;

    public ProductDO() {
    }

    public ProductDO(String name) {
        this.name = name;
        this.styleName = "";
    }

    public int getPrimaryKey() {
        return this.id;
    }

    public void setPrimaryKey(int key) {
        this.id = key;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStyle() {
        return this.styleName;
    }

    public void setStyle(String styleName) {
        this.styleName = styleName;
    }
}
