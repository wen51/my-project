package com.jw.myproject.pattern.proxy.staticproxy.dynamicproxy.jwproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

/**
 * 主要是动态生成代码
 * @author lijw
 * @date 2020/10/29 16:14
 */
public class JWProxy {

    public static final String ln = "\r\n";

    public static Object newProxyInstance(JWClassLoder loader,
                                          Class<?>[] interfaces,
                                          JWInvocationHandler h) {
        try {
            String src = generateSrc(interfaces);
        } catch (Exception e ) {
            e.printStackTrace();
        }
        return null;
    }

    private static String generateSrc(Class<?>[] interfaces) {
        //用代码生成代码
        StringBuilder sb = new StringBuilder();
        sb.append("package com.jw.myproject.pattern.proxy.staticproxy.dynamicproxy.jwproxy;" + ln);
        sb.append("import com.jw.myproject.pattern.proxy.staticproxy.Person;" + ln);
        sb.append("import java.lang.reflect.*;" + ln);
        sb.append("public class $Proxy0 implements " + interfaces[0].getName() + "{" +ln);
            sb.append("JWInvocationHandler h;" +ln);
            sb.append("public $Proxy0(JWInvocationHandler h) {" + ln);
                sb.append("this.h = h;" +ln);
            sb.append("}" +ln);

            for (Method m : interfaces[0].getMethods()) {
                sb.append("public " + m.getReturnType().getName() + " " + m.getName() + " () {" + ln);
                    sb.append("try {" + ln);
                        sb.append("Method m = " + interfaces[0].getName() + ".class.getMethod(\"" + m.getName() +"\")" + ln);
                    sb.append("} catch (Exception e ) {\n" +
                            "            e.printStackTrace();\n" +
                            "        }" + ln);
                sb.append("}" + ln);
            }
        sb.append("}");
        return null;
    }
}
