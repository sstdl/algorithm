package com.sstdl.leetcode.hot_100.linkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SSTDL
 * @description 234. 回文链表
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 *
 * 示例 1：
 * 输入：head = [1,2,2,1]
 * 输出：true
 *
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：false
 */
public class isPalindrome_easy_234 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 1};
        ListNode head = ListNodeUtils.createListNode(nums);
        boolean palindrome = isPalindrome(head);
        System.out.println(palindrome);
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode cur = head;
        List<Integer> array = new ArrayList<>();
        while (cur != null) {
            array.add(cur.val);
            cur = cur.next;
        }
        int len = array.size();
        for (int i = 0; i < len / 2; i++) {
            if (!array.get(i).equals(array.get(len - 1 - i))) {
                return false;
            }
        }
        return true;
    }
}
