package com.jw.myproject.myproject.bean;

public class SuperClass {
    private String parent;

    public String pubField;

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public void hello(){
        System.out.println("hello");
    }

}
