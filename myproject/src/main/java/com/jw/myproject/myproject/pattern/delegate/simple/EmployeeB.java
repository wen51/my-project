package com.jw.myproject.myproject.pattern.delegate.simple;

public class EmployeeB implements IEmployee {
    @Override
    public void doing(String commond) {
        System.out.println("我是员工B，我擅长加密，正在执行命令：" + commond);
    }
}
