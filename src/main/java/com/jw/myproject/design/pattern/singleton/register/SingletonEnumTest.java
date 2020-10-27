package com.jw.myproject.design.pattern.singleton.register;

import java.io.*;

/**
 * @author lijw
 * @date 2020/10/26 17:26
 */
public class SingletonEnumTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SingleEnum s1 = SingleEnum.getInstance();
        s1.setData(new Object());
        System.out.println("s1=" + s1.getData());

        SingleEnum s2 = null;

        //序列化
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("SingleEnum.obj"));
        oos.writeObject(s1);
        oos.flush();
        oos.close();

        //反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("SingleEnum.obj"));
        s2 = (SingleEnum) ois.readObject();
        ois.close();

        System.out.println("s2=" + s2.getData());

        System.out.println(s1.getData() == s2.getData());
    }
}
