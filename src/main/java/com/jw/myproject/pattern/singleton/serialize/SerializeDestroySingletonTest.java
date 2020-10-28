package com.jw.myproject.pattern.singleton.serialize;

import java.io.*;

/**
 * @author lijw
 * @date 2020/10/23 15:12
 */
public class SerializeDestroySingletonTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerializeSingleton s1 = SerializeSingleton.getInstance();
        System.out.println("s1=" + s1);

        SerializeSingleton s2 = null;

        //序列化
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("SerializeSingleton.obj"));
        oos.writeObject(s1);
        oos.flush();
        oos.close();

        //反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("SerializeSingleton.obj"));
        s2 = (SerializeSingleton) ois.readObject();
        ois.close();

        System.out.println("s2=" + s2);

        System.out.println(s1 == s2);

    }
}
