package com.jw.myproject.myproject.controller;

import com.jw.myproject.myproject.bean.ChildClass;

public class ExtendsController {

    public static void main(String[] args) {
        ChildClass child = new ChildClass();
        child.pubField = "public";
        child.hello();
    }
}
