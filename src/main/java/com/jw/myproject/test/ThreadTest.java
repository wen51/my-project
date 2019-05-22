package com.jw.myproject.test;

public class ThreadTest {

    public static void main(String[] args) {
        ThreadTest test = new ThreadTest();
        test.wait();
    }

    public void say(){
        System.out.println("Hello World");
    }
}
