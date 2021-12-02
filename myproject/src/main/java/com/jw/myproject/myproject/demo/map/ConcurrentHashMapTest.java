package com.jw.myproject.myproject.demo.map;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put(null, null);
        map.put(null, null);
        System.out.println(map.size());
        ConcurrentHashMap<String, String> cmap = new ConcurrentHashMap<>();
        cmap.put(null, null);
        System.out.println(cmap.size());
    }
}
