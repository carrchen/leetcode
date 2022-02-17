package com.example.demo.algorithm.common;


public class ListUtils {
    public static ListNode create(int [] array) {
        ListNode dummyhead = new ListNode(-1);
        for (int i = 0; i < array.length; i++) {
            ListNode node = new ListNode(array[i]);
            node.next = dummyhead.next;
            dummyhead.next = node;
        }
        return dummyhead.next;
    }

    //倒叙打印链表
    public static void printList(ListNode head) {
        if (head == null) {
            return;
        }
        printList(head.next);
        System.out.println(head.val);
    }
}
