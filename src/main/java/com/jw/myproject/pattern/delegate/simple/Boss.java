package com.jw.myproject.pattern.delegate.simple;

public class Boss {

    public void commond(Leader leader, String commond){
        System.out.println("Boss下命令：" + commond);
        leader.doing(commond);
    }
}
