package com.example.demo.algorithm.num328_OddEvenList;

/**
 * 给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
 *
 * 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。
 *
 * 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
 *
 * 你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。
 *
 *  
 *
 * 示例 1:
 *
 *
 *
 * 输入: head = [1,2,3,4,5]
 * 输出: [1,3,5,2,4]
 * 示例 2:
 *
 *
 *
 * 输入: head = [2,1,3,5,6,4,7]
 * 输出: [2,3,6,7,1,5,4]
 *  
 *
 * 提示:
 *
 * n ==  链表中的节点数
 * 0 <= n <= 104
 * -106 <= Node.val <= 106
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/odd-even-linked-list
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


    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode event = head.next;
        ListNode eventHead = event;
        while (event != null && event.next != null) {
            odd.next = event.next;
            odd = odd.next;
            event.next = odd.next;
            event = event.next;
        }
        odd.next= eventHead;
        return head;
    }

    //倒叙打印链表
    public void printList(ListNode head) {
        if (head == null) {
            return;
        }
        printList(head.next);
        System.out.println(head.val);
    }

    public  ListNode create(int [] array) {
        ListNode dummyhead = new ListNode(-1);
        for (int i = 0; i < array.length; i++) {
            ListNode node = new ListNode(array[i]);
            node.next = dummyhead.next;
            dummyhead.next = node;
        }
        return dummyhead.next;
    }

    public static void main(String[] args) {
        ListNode node = new Solution().create(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        new Solution().printList(node);

    }
}
