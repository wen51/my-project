package com.jw.myproject.myproject.pattern.proxy.staticproxy;

/**
 * 父亲类，给儿子找对象
 * @author lijw
 * @date 2020/10/28 16:35
 */
public class Father {

    private Person person;

    public Father(Person person) {
        this.person = person;
    }

    /**
     * 父亲帮儿子找对象找对象
     */
    public void findLove() {
        System.out.println("父亲物色对象");
        person.findLove();
        System.out.println("凑合成功");
    }
}
