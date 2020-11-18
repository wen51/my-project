package com.jw.myproject.pattern.delegate.simple;

public class DelegateTest {

    public static void main(String[] args) {
        Boss boss = new Boss();
        Leader leader = new Leader();
        boss.commond(leader, "加密");
        boss.commond(leader, "架构");
    }
}
