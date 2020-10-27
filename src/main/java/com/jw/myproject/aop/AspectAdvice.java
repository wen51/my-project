package com.jw.myproject.aop;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tsign
 */
//@Aspect
//@Component
public class AspectAdvice {

    // 指定关键字
    public static String KEY_WORD = "总计:";
    // PDF当前页数
    public static int curPage = 0;
    // 集合里放了多少条数据
    public static int count = 0;
    // 坐标信息集合
    public static List<float[]> arrays = new ArrayList<float[]>();
    // 关键字字符数组
    public static char[] charArray = KEY_WORD.toCharArray();
    public static void main(String[] args) {
        String s = new String(charArray, 1, 1);
        System.out.println(s);
    }
}
