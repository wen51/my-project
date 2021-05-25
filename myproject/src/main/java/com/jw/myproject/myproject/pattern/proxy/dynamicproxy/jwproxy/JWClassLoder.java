package com.jw.myproject.myproject.pattern.proxy.dynamicproxy.jwproxy;

import java.io.*;

/**
 * @author lijw
 * @date 2020/10/29 16:15
 */
public class JWClassLoder extends ClassLoader {

    private File classPathFile;

    public JWClassLoder() {
        String classPath = JWClassLoder.class.getResource("").getPath();
        System.out.println("JWClassLoder：构造器读取本类路径==>" + classPath);
        this.classPathFile = new File(classPath);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //找到类路径 + 类名
        String className = JWClassLoder.class.getPackage().getName() + "." + name;
        if (classPathFile != null) {
            File classFile = new File(classPathFile,name.replaceAll("\\.","/") + ".class");
            System.out.println("JWClassLoder：JWClassLoder.findClass()方法读取的class路径==>" + classFile.getAbsolutePath());
            if(classFile.exists()) {
                FileInputStream in = null;
                ByteArrayOutputStream out = null;
                try {
                    in = new FileInputStream(classFile);
                    out = new ByteArrayOutputStream();
                    byte[] buff = new byte[1024];
                    int len;
                    while ((len = in.read(buff)) != -1) {
                        out.write(buff, 0, len);
                    }
                    //jvm原生方法
                    return defineClass(className, out.toByteArray(), 0, out.size());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
