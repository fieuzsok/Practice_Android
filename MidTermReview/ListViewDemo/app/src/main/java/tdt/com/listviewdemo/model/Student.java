package tdt.com.listviewdemo.model;

public class Student {
    private String mSSV;
    private String hoTen;
    private int srcID;
    private  boolean selected;

    public Student(String mSSV, String hoTen, int srcID, boolean selected) {
        this.mSSV = mSSV;
        this.hoTen = hoTen;
        this.srcID = srcID;
        this.selected = selected;
    }

    public String getmSSV() {
        return mSSV;
    }

    public void setmSSV(String mSSV) {
        this.mSSV = mSSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getSrcID() {
        return srcID;
    }

    public void setSrcID(int srcID) {
        this.srcID = srcID;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
