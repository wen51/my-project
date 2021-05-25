package com.jw.myproject.myproject.pattern.singleton.register;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 枚举式单例测试验证
 * @author lijw
 * @date 2020/10/26 17:26
 */
public class SingletonEnumTest {

//    /**
//     * 通过序列化生成实例验证
//     */
//    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        SingleEnum s1 = SingleEnum.getInstance();
//        s1.setData(new Object());
//        System.out.println("s1=" + s1.getData());
//
//        SingleEnum s2 = null;
//
//        //序列化
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("SingleEnum.obj"));
//        oos.writeObject(s1);
//        oos.flush();
//        oos.close();
//
//        //反序列化
//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("SingleEnum.obj"));
//        s2 = (SingleEnum) ois.readObject();
//        ois.close();
//
//        System.out.println("s2=" + s2.getData());
//
//        System.out.println(s1.getData() == s2.getData());
//    }

    static ThreadLocal<SingletonEnumTest> t = new ThreadLocal<>();

    /**
     * 通过反射生成实例验证
     */
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<SingleEnum> clazz = SingleEnum.class;
        Constructor<SingleEnum> constructor = clazz.getDeclaredConstructor(String.class, int.class);
        constructor.setAccessible(true);
        SingleEnum singleEnum = constructor.newInstance("sdf", 123);
        System.out.println(singleEnum);

        SingletonEnumTest singletonEnumTest = t.get();

    }

}
