package test_final;

import java.io.Serializable;
import java.util.Date;

public class Item {

    private static final long serialVersionUID = 9066570702294546118L;
    private int id;
    private String name;
    private String description;
    private Date expire;

    public Item() {
        this(0, "", "", null);
    }

    public Item(int id, String name, String description, Date expire) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.expire = expire;
    }

    public Date getExpire() {
        return expire;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setExpire(Date expire) {
        this.expire = expire;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
