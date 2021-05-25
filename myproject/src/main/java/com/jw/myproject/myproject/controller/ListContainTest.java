package com.jw.myproject.myproject.controller;

import java.util.*;

public class ListContainTest {

    public static void main(String[] args) {
        ArrayList<Integer> arrray = new ArrayList<>();
        LinkedList<Integer> link = new LinkedList<>();
//        for (int i = 0; i < 10000; i++) {
//            arrray.add(i);
//            link.add(i);
//        }
        long start = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            arrray.add(i, 1);
        }
        System.out.println("update arry:"+(System.nanoTime()-start));
        long s = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            link.add(i, 1);
        }
        System.out.println("update Link:"+(System.nanoTime()-s));
    }
}
