package com.jw.myproject.myproject.test.string;

public class StringTest {

    public static void main(String[] args) {
        String a = "a";
        String b = "b";
        String c = "c";
        String d = "d";
        String e = "e";
        String s00 = a;
        String s0 = a + b;
        String s1 = a + b + c;
        String s2 = a + b + c + d;
        String s3 = a + b + c + d + e;

        System.out.println(s00);
        System.out.println(s0);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        String s4 = "h" +"i"+"j"+"k"+"l";
        System.out.println(s4);
//        System.out.println(s == s2);
    }
}
