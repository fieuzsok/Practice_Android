package com.example.user.listviewdemo;

public class Model {
    private String type;
    private boolean isCheck;

    public Model() {
    }

    public Model(String type, boolean isCheck) {
        this.type = type;
        this.isCheck = isCheck;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }
}
