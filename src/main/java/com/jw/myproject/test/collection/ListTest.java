package com.jw.myproject.test.collection;

import java.util.*;

public class ListTest {

    public static void main(String[] args) {
        Set<Object> set = new HashSet<>();
        for(int i=0; i<100; i++){
            Random random = new Random();
            set.add(random.nextInt(101));
        }

        Iterator<Object> iteratorSet = set.iterator();

        while (iteratorSet.hasNext()){
            System.out.print(","+iteratorSet.next());
        }

        System.out.println();
        System.out.println("set:"+set.size());
        List<Object> list = new ArrayList<>();
        for(int i=0;i<100; i++){
            Random random = new Random();
            list.add(random.nextInt(101));

        }
        Iterator<Object> iteratorList = list.iterator();

        while (iteratorList.hasNext()){
            System.out.print(","+iteratorList.next());
        }
        System.out.println();
        System.out.println(list.size());
    }
}
