package com.jw.myproject.myproject.test.collection;

import org.springframework.util.CollectionUtils;

import java.util.*;

public class ListTest {
    //迭代次数
    public static int ITERATION_NUM = 10000;
    public static void main(String[] agrs) {
//        insertPerformanceCompare();
//        sort();
        String a = "abc";
        String b = String.valueOf("abc");
        String c = new String("abc");
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(b == c);
    }

    public static void sort(){
        List<String> lit = new ArrayList<>();
        lit.add("abc");
        lit.add("def");
        lit.add("aaa");
        lit.add("abc");
        Collections.sort(lit);
        System.out.println(lit.get(0));
        for(String s : lit){
            System.out.println(s);
        }
    }

    //新增性能比较：
    public static void insertPerformanceCompare() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("LinkedList新增测试开始");
        long start = System.nanoTime();
        List<Integer> linkedList = new LinkedList<Integer>();
        for (int x = 0; x < ITERATION_NUM; x++) {
            linkedList.add(x);
        }
        long end = System.nanoTime();
        long linkCost = end - start;
        System.out.println(linkCost);

        System.out.println("ArrayList新增测试开始");
        long arrayStart = System.nanoTime();
        List<Integer> arrayList = new ArrayList<Integer>();
        for (int x = 0; x < ITERATION_NUM; x++) {
            arrayList.add(0,x);
        }
        long arrayEnd = System.nanoTime();
        long arrayCost = arrayEnd - arrayStart;
        System.out.println(arrayCost);
        System.out.println("LinkedList新增更快："+ (linkCost < arrayCost));
    }

}
