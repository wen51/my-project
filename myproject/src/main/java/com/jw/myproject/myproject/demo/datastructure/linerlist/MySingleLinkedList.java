package com.jw.myproject.myproject.demo.datastructure.linerlist;

import lombok.Data;

/**
 * @author lijw
 * @date 2021/12/1 18:08
 */
@Data
public class MySingleLinkedList<T> {

    /**
     * 第一个元素
     */
    Node<T> first;

    /**
     * 最后一个元素
     */
    Node<T> last;

    public boolean addFirst(T t) {
        Node<T> newNode = new Node<>(null, t, first);
        if (first == null) {
            last = newNode;
        }
        first = newNode;
        return true;
    }

    public boolean addLast(T t) {
        Node<T> newNode = new Node<>(last, t, null);
        if (last == null) {
            first = newNode;
        } else {
            Node oldLast = last;
            oldLast.next = newNode;
        }
        last = newNode;
        return true;
    }

    public T removeFirst() {
        if (first == null) {
            return null;
        }
        T data = first.data;
        first = first.next;
        if (first == null) {
            last = null;
        } else {
            first.pre = null;
        }
        return data;
    }


    @Data
    public static class Node<T> {

        /**
         * 前驱
         */
        public Node<T> pre;

        /**
         * 存储数据
         */
        public T data;

        /**
         * 后继，下个元素
         */
        public Node<T> next;

        public Node(Node pre, T data, Node next) {
            this.pre = pre;
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "pre=" + (pre == null ? null : pre.data) +
                    ", data=" + data +
                    ", next=" + (next == null ? null : next.data) +
                    '}';
        }
    }

    public static void main(String[] args) {
        MySingleLinkedList<String> list = new MySingleLinkedList<>();
        System.out.println(list);
        list.addLast("test1");
        System.out.println(list);
        list.addLast("test2");
        System.out.println(list);
        list.addLast("test3");
        System.out.println(list);

    }

}
