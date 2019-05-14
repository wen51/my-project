package com.jw.myproject.controller;

import com.jw.myproject.service.DefaultService;
import org.springframework.stereotype.Controller;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Controller
public class DefaultController {

    private DefaultService defaultService;

    public static void main(String[] args) {
//        test();
        testHashMap();
    }

    public static void test(){
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i <10; i++) {
//            list.add(i);
//        }
//        list.add(5, 100);
//
//        System.out.println(list);

        List<Integer> linkList = new LinkedList<>();

        for (int i = 0; i <10; i++) {
            linkList.add(i);
        }
        linkList.add(5, 100);
        System.out.println(linkList);
        List<Integer> linkList2 = new LinkedList<>(linkList);

    }

    public static void testHashMap(){
        Map<String , String> map = new ConcurrentHashMap<>();
        Map<String , String> hashmap = new HashMap<>();
        Map<String, String> hashTable = new Hashtable<>();
        hashTable.put(null, null);

        Float f = 1f;
        System.out.println(f.isNaN());
    }

}
