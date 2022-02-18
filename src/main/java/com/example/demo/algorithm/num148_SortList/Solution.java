package com.example.demo.algorithm.num148_SortList;

import com.example.demo.algorithm.common.ListNode;

import java.util.List;

/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 示例 2：
 *
 *
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * 示例 3：
 *
 * 输入：head = []
 * 输出：[]
 *  
 *
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 5 * 104] 内
 * -105 <= Node.val <= 105
 *  
 *
 * 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        return sort(head);
    }

    private ListNode sort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //快慢指针找mid，将链表分拆
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        ListNode leftNode = sortList(head);
        ListNode rightNode = sortList(mid);
        return merge(leftNode, rightNode);
    }


    private ListNode merge(ListNode lHead, ListNode rHead) {
        ListNode dummyNode = new ListNode(-1);
        ListNode pre = dummyNode;

        while (lHead != null && rHead != null) {
            if (lHead.val >= rHead.val) {
                pre.next = rHead;
                rHead = rHead.next;
            } else {
                pre.next = lHead;
                lHead = lHead.next;
            }
            pre = pre.next;
        }
        pre.next = lHead == null ? rHead:lHead;
        return dummyNode.next;
    }
}
