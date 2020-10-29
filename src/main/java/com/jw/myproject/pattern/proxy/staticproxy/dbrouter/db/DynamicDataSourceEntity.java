package com.jw.myproject.pattern.proxy.staticproxy.dbrouter.db;

/**
 * @author lijw
 * @date 2020/10/29 9:51
 */
public class DynamicDataSourceEntity {

    public final static String DEFAULT_SOURCE = null;

    private final static ThreadLocal<String> local = new ThreadLocal<>();

    private DynamicDataSourceEntity() {

    }

    private static String get() {
        return local.get();
    }

    /**
     * 设置数据源
     */
    public static void set(String source) {
        local.set(source);
    }

    /**
     * 设置数据源
     */
    public static void set(int year) {
        String source = "DB_" + year;
        System.out.println("设置数据源：" + source);
        local.set(source);
        System.out.println("现有数据源：" + local.get());
    }

    /**
     * 重置数据源
     */
    public static void restore() {
        System.out.println("重置数据源完成");
        local.set(DEFAULT_SOURCE);
        System.out.println("重置后现有数据源：" + local.get());
    }
}
