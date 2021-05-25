package com.jw.myproject.myproject.pattern.proxy.dynamicproxy.jwproxy;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 用来生成源代码的工具类，仅此而已
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
            //1、用代码生成源代码
            String src = generateSrc(interfaces);

            // 2、保存成.java文件输出到磁盘
            String filePath = JWProxy.class.getResource("").getPath();
            System.out.println(filePath);
            File f = new File(filePath + "$Proxy0.java");
            System.out.println("JWProxy：java文件写入的路径==>" + f.getAbsolutePath());
            FileWriter fw = new FileWriter(f);
            fw.write(src);
            fw.flush();
            fw.close();

            // 3、将生成的.java文件编译成.class文件
            JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager fileManager = javaCompiler.getStandardFileManager(null, null, null);
            Iterable<? extends JavaFileObject> iterable = fileManager.getJavaFileObjects(f);

            //创建编译任务
            JavaCompiler.CompilationTask task = javaCompiler.getTask(null, fileManager, null, null, null, iterable);
            task.call();
            fileManager.close();

            // 4、将编译生成的.class文件加载到jvm中
            Class<?> proxyClass = loader.findClass("$Proxy0");
            Constructor<?> constructor = proxyClass.getConstructor(JWInvocationHandler.class);

            // 5、返回字节码重组后的新的代理对象
            return constructor.newInstance(h);
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
                        sb.append("Method m = " + interfaces[0].getName() + ".class.getMethod(\"" + m.getName() +"\", new Class[]{});" + ln);
                        sb.append("this.h.invoke(this, m, null);" + ln);
                    sb.append("} catch (Throwable e ) {\n" +
                            "            e.printStackTrace();\n" +
                            "        }" + ln);
//                    sb.append("return null;" + ln);
                sb.append("}" + ln);
            }
        sb.append("}");
        return sb.toString();
    }
}
