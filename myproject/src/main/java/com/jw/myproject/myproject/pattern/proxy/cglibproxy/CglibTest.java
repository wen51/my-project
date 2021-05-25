package com.jw.myproject.myproject.pattern.proxy.cglibproxy;

import org.springframework.cglib.core.DebuggingClassWriter;

/**
 * @author lijw
 * @date 2020/11/5 11:09
 */
public class CglibTest {

    public static void main(String[] args) throws Exception {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "E://cglib_proxy_classes");
        Customer obj = (Customer) new CGlibMeipo().getInstance(Customer.class);
        System.out.println(obj);
        obj.findLove();
    }
}
