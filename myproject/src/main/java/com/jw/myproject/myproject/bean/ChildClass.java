package com.jw.myproject.myproject.bean;

/**
 * @author tsign
 */
public class ChildClass extends SuperClass {
    private String child;

    public String getChild() {
        return child;
    }

    public void setChild(String child) {
        this.child = child;
    }


    public void test(String s){
        return;
    }

    @Override
     public void hello(){
        super.hello();
        System.out.println("hello child");
    }
}
