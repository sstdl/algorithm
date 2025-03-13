package com.sstdl.leetcode.hot_100.linkedList;

import java.util.ArrayList;

/**
 * @author SSTDL
 * @description 25. K 个一组翻转链表
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 * <p>
 * 示例 2：
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 */
public class reverseKGroup_hard_25 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k = 2;
        ListNode head = ListNodeUtils.createListNode(nums);
        ListNode listNode = reverseKGroup(head, k);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    // 使用额外数组遍历-AC（手撕）
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        ArrayList<Integer> list = new ArrayList<>();
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }
        int len = list.size();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = list.get(i);
        }
        ListNode newHead = new ListNode(nums[k - 1]);
        ListNode newCurr = newHead;
        int kVolume = len - len % k;
        for (int i = k - 2; i >= 0; i --) {
            newCurr.next = new ListNode(nums[i]);
            newCurr = newCurr.next;
        }
        if (kVolume - k > 0) {
            for (int i = 2 * k - 1; i < kVolume; i += k ) {
                for (int j = i; j > i - k; j--) {
                    newCurr.next = new ListNode(nums[j]);
                    newCurr = newCurr.next;
                }
            }
        }
        for (int i = kVolume; i < len; i++) {
            newCurr.next = new ListNode(nums[i]);
            newCurr = newCurr.next;
        }
        return newHead;
    }
}
