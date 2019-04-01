package tdt.com.actionbardemo.model;

public class ItemClass {
    private int srcID;
    private String name;

    public ItemClass(int srcID, String name) {
        this.srcID = srcID;
        this.name = name;
    }

    public int getSrcID() {
        return srcID;
    }

    public void setSrcID(int srcID) {
        this.srcID = srcID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
