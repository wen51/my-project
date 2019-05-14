package com.jw.myproject.utils.quotetest;

public class TestB {

    private int a;

    public TestB(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public static void swapObj(TestA a1, TestA a2){
        TestA a3 = a1;
        a1 = a2;
        a2 = a3;

        System.out.println(a1.getA()+","+a2.getA());
    }

    public static void swapValue(TestA a1, TestA a2){
        int a = a1.getA();
        a1.setA(a2.getA());
        a2.setA(a);

        System.out.println(a1.getA()+","+a2.getA());
    }

//    public static void main(String[] args) {
//        TestA a1 = new TestA(1);
//        TestA a2 = new TestA(2);
//
//        System.out.println(a1.getA());
//        System.out.println(a2.getA());
//
////        swapObj(a1, a2);
//        swapValue(a1, a2);
//
//        System.out.println(a1.getA());
//        System.out.println(a2.getA());
//
//    }

//    public static void main(String[] args) {
//
//        //demo1
//        String str=new String("hello");
//        char []chs={'w','o','r','l','d'};
//        change(str, chs);
//        System.out.println(str+" "+new String(chs));
//
//        //-------------------------------------------------
//        //demo2
//
//        StringBuffer sb=new StringBuffer("hello");
//        change(sb);
//        System.out.println(sb);
//
//    }
//    public static void change(StringBuffer sb)
//    {
//        sb.append(" world");
////      sb.deleteCharAt(0);
//    }
//    public static void change(String str,char[]chs)
//    {
//        str.replace('h', 'H');
//        chs[0]='W';
//    }

    public static void main(String sgf[]) {

        StringBuffer a=new StringBuffer("A");
        StringBuffer b=new StringBuffer("B");
        operate(a,b);
        System.out.println(a+"."+b);

    }

    static void operate(StringBuffer x,StringBuffer y) {

        x.append(y);
        y=x;

    }
}
