package com.example.demo.algorithm.num234_IsPalindrome;

import com.example.demo.algorithm.common.ListNode;
import com.example.demo.algorithm.common.ListUtils;
import lombok.val;

/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,2,1]
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：head = [1,2]
 * 输出：false
 *  
 *
 * 提示：
 *
 * 链表中节点数目在范围[1, 105] 内
 * 0 <= Node.val <= 9
 *  
 *
 * 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        //找中点，快慢指针，快指针是慢的2倍，当快指针便利完的时候慢指针在中间
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //断开链表
        ListNode cur = slow.next;
        slow.next = null;
        fast = head;
        ListNode listNode = reverseList(cur);
        //判断两个链表值是否相等
        while (listNode != null) {
            if (fast.val != listNode.val) {
                return false;
            }
            fast = fast.next;
            listNode = listNode.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode listNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return listNode;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        ListNode listNode = ListUtils.create(arr);
        Solution solution = new Solution();
        solution.isPalindrome(listNode);
    }
}
