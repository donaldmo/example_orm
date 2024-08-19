package za.co.wethinkcode.persist.orm;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "styles")
public class StyleDO {
    @DatabaseField(id = true)
    private int id;

    @DatabaseField
    private String name;

    // Default constructor required by ORMLite
    StyleDO() {
    }

    // Getters and Setters
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