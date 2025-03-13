package com.sstdl.leetcode.hot_100.linkedList;

/**
 * @author SSTDL
 * @description 创建链表
 */
public class ListNodeUtils {
    public static ListNode createListNode(int[] nums) {
        ListNode head = new ListNode(nums[0]);
        ListNode cur = head;
        for (int i = 1; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
        return head;
    }
}
