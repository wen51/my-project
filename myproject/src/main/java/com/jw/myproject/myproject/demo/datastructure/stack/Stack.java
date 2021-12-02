package com.jw.myproject.myproject.demo.datastructure.stack;

import com.jw.myproject.myproject.demo.datastructure.linerlist.MySingleLinkedList;

/**
 * @author lijw
 * @date 2021/12/1 11:31
 */
public class Stack<T> {

    private MySingleLinkedList<T> list;

    private void init() {
        if (list == null) {
            list = new MySingleLinkedList<>();
        }
    }

    public boolean isEmpty() {
        return list == null || list.getFirst() == null;
    }

    public void push(T data) {
        init();
        list.addFirst(data);
    }

    public T pop() {
        init();
        return list.removeFirst();
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        System.out.println(stack.isEmpty());
        System.out.printf("出栈：%s", stack.pop());
        stack.push("第一次入栈");
        System.out.println("第一次入栈：");
        stack.push("第er次入栈");
        System.out.println("第er次入栈：");
        System.out.printf("出栈：%s", stack.pop());
        System.out.printf("出栈：%s", stack.pop());
    }
}
