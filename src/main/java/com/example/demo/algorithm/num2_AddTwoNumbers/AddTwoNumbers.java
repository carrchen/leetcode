package com.example.demo.algorithm.num2_AddTwoNumbers;


/**
给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。

请你将两个数相加，并以相同形式返回一个表示和的链表。

你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-two-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddTwoNumbers {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode();
        ListNode nextNode = result;
        int l1_val = l1.val;
        int l2_val = l2.val;
        result.val = (l1_val + l2_val) % 10;
        boolean flag = (l1_val + l2_val) / 10 > 0 ? true : false;
        while(l1.next != null || l2.next != null) {
            ListNode next = new ListNode();

            l1_val = l1.next == null ? 0 : l1.next.val;
            l2_val = l2.next == null ? 0 : l2.next.val;
            
            if(flag) {
                if(l1_val + l2_val + 1 > 9) {
                    next.val = (l1_val + l2_val + 1) % 10;
                } else {
                    next.val = l1_val + l2_val + 1;
                    flag = false;
                }
            } else {
                if(l1_val + l2_val > 9) {
                    next.val = (l1_val + l2_val) % 10;
                    flag = true;
                } else {
                    next.val = l1_val + l2_val;
                    flag = false;
                }
            }
            nextNode.next = next;
            nextNode = next;
            
            l1 = l1.next == null ? l1 : l1.next;
            l2 = l2.next == null ? l2 : l2.next;
        }
        if(flag) {
            nextNode.next = new ListNode(1);
        }
        return result;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        ListNode root = new ListNode();
        ListNode cursor = root;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
            int l1_val = l1 == null ? 0 : l1.val;
            int l2_val = l2 == null ? 0 : l2.val;
            int sum_val = l1_val + l2_val + carry;

            carry = sum_val / 10;
            ListNode sum = new ListNode((sum_val) % 10);
            cursor.next = sum;
            cursor = sum;

            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }
        return root.next;
    }

    public static void main(String[] args) {
        int i = 7;
        System.out.println(i / 10);
        System.out.println(i % 10);
    }
}