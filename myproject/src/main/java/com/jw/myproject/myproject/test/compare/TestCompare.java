package com.jw.myproject.myproject.test.compare;

import lombok.Data;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class TestCompare {
    private Integer a;


    public static void main(String[] args) {
        int[] i = new int[1];
        test1();


        //stream
        ArrayList<String> list = new ArrayList<>();
        list.add("123");
        list.add("456");
        List<People> peopleList = list.stream().map(People::new).collect(Collectors.toList());
        System.out.println(peopleList);
    }

    private static void test1() {
        ActionListener a = event -> System.out.println("111");
        Timer t = new Timer(1000, System.out::println);
        Timer t2 = new Timer(1000, a);
        t.start();
        t2.start();
    }

}

@Data
class People{
    String name;

    public People(String name) {
        this.name = name;
    }
}
