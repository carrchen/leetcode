package com.example.demo.algorithm.num203_RemoveElements;

/**
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 示例 2：
 *
 * 输入：head = [], val = 1
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 *  
 *
 * 提示：
 *
 * 列表中的节点数目在范围 [0, 104] 内
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-linked-list-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */



public class Solution {

    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode pre = head;
        while (pre != null && pre.next != null) {
            ListNode node = pre.next;
            if (node.val == val) {
                pre.next = node.next;
                node.next = null;
            } else {
                pre = pre.next;
            }
        }
        return head;
    }

    public ListNode removeElements2(ListNode head, int val) {

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        while (pre.next != null) {
            ListNode node = pre.next;
            if (node.val == val) {
                pre.next = node.next;
                node.next = null;
            } else {
                pre = pre.next;
            }
        }
        return dummyNode.next;
    }

    public ListNode removeElements3(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode node = removeElements(head.next, val);
        if (head.val == val) {
            return node;
        } else {
            head.next = node;
            return head;
        }
    }
}
