package za.co.wethinkcode.persist.orm;

//import com.j256.ormlite.field.DatabaseField;
//import com.j256.ormlite.table.DatabaseTable

//@DatabaseTable( tableName = "styles" )
public class StyleDO {
    // @DatabaseTable(tableName = "styles")
    private int id;

    // @DatabaseField
    private String name;

    StyleDO() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
