package com.example.demo.linklist;


import jdk.nashorn.internal.runtime.linker.LinkerCallSite;
import lombok.val;

public class LinkList<T> {
    private class Node {
        public T value;
        public Node next;

        public Node() {
        }
        public Node(T value) {
            this.value = value;
            this.next = null;
        }

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node head;
    private int size;

    public LinkList() {
        this.head = null;
        this.size = 0;
    }

    //添加head元素
    public void addFirst(T value) {
        if (size == 0) {
            head = new Node(value);
        } else {
            Node node = new Node(value);
            node.next = head;
            head = node;
        }
        size++;
    }

    //任意位置添加元素
    public void add(T val, int index) {
        if (index == 0) {
            addFirst(val);
        } else {
            Node pre = head;
            for (int i = 0; i < index-1; i++) {
                pre = pre.next;
            }
            Node node = new Node();
            node.value = val;
            node.next = pre.next;
            pre.next = node;
            size++;
        }
    }

    //尾部添加元素
    public void addTail(T value) {
        add(value, size);
    }

    //修改任意位置元素
    public void set(T val, int index) {
        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.value = val;
    }

    //修改头部元素
    public void setHead(T val) {
        set(val, 0);
    }

    //修改尾部元素
    public void setTail(T val) {
        set(val, size-1);
    }

    //删除任意位置元素
    public T del(int index) {
        Node pre = head;
        if (index == 0) {
            head = head.next;
            size--;
            return pre.value;
        }

        for (int i = 0; i < index-1; i++) {
            pre = pre.next;
        }
        Node delNode = pre.next;
        pre.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.value;
    }

    //删除头部元素
    public T delHead() {
        return del(0);
    }

    //删除尾部元素
    public T delTail() {
        return del(size-1);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("head: ");
        Node cur = head;
        while (cur != null) {
            sb.append(cur.value);
            sb.append(" -> ");
            cur = cur.next;
        }
        sb.append("Null");
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkList list = new LinkList<Integer>();
        for (int i = 0; i < 5; i++) {
            list.addFirst(i);
        }
        System.out.println(list);
        list.add(6, 2);
        System.out.println(list);
        list.addFirst(8);
        System.out.println(list);
        list.addTail(8);
        System.out.println(list);
        list.del(3);
        System.out.println(list);
        list.delHead();
        System.out.println(list);
        list.delTail();
        System.out.println(list);

    }
}
