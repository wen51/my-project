package com.jw.myproject.bean;

import com.jw.myproject.bean.Outer;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.setName("Tom");
        System.out.println(outer.getName());

        Outer.Inner inner = outer.new Inner();
        inner.printName();

        Outer outer2 = new Outer(){
            @Override
            public void setName(String name) {
                super.setName(name+"dadada");

            }
        };
        outer2.setName("www");

        System.out.println(outer2.getName());

        outer.testPart(10);
    }
}
