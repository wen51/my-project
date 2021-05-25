package com.jw.myproject.myproject.bean;

import lombok.Data;

@Data
public class Outer {

    private String name;

    @Data
    class Inner{

        private String name;

        public void printName(){
            System.out.println(Outer.this.name);
        }
    }

    public void testPart(int a){
        int b = 0;
        new ChildClass() {
            public void hello() {
                System.out.println("Hello Part" + a);
                System.out.println(b);
            }
        }.hello();
        new Thread(){
            @Override
            public void run() {
                System.out.println("thread"+a);
            }
        }.start();
    }

    static class StaticInner{

    }
}
