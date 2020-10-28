package com.jw.myproject.pattern.singleton.serialize;

import java.io.Serializable;

/**
 * @author lijw
 * @date 2020/10/23 15:10
 */
public class SerializeSingleton implements Serializable {

    /**
     * 饿汉模式
     */
    private static SerializeSingleton hungry = new SerializeSingleton();

    private SerializeSingleton() {

    }

    public static SerializeSingleton getInstance() {
        return hungry;
    }

    private Object readResolve() {
        return hungry;
    }
}
