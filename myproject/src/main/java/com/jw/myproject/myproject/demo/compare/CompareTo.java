package com.jw.myproject.myproject.demo.compare;

import java.util.Arrays;

public class CompareTo {
    public static void main(String[] args) {
        TestCompare[] t = new TestCompare[]{
                new TestCompare(), new TestCompare()
        };
        Arrays.sort(t);
        System.out.println(t);
    }
}
