package com.jw.myproject.myproject.pattern.delegate.simple;

public class EmployeeA implements IEmployee {
    @Override
    public void doing(String commond) {
        System.out.println("我是员工A，我擅长架构，正在执行命令：" + commond);
    }
}
