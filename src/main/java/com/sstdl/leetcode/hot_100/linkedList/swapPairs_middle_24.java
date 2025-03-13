package com.sstdl.leetcode.hot_100.linkedList;

/**
 * @author SSTDL
 * @description 24. 两两交换链表中的节点
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 *
 * 示例 2：
 * 输入：head = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：head = [1]
 * 输出：[1]
 */
public class swapPairs_middle_24 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        ListNode head = ListNodeUtils.createListNode(nums);
        ListNode listNode = swapPairs(head);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    // 遍历交换-AC（手撕）
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        // 虚拟节点，简化操作
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr.next != null && curr.next.next != null) {
            // 第一个节点
            ListNode next = curr.next;
            // 第二个节点
            ListNode nextNext = next.next;
            // 后续节点
            ListNode tmp = nextNext.next;
            // 交换
            // 第二个节点指向第一个节点
            nextNext.next = next;
            // 第一个节点指向后续节点
            next.next = tmp;
            // 链接交换后的链表
            curr.next = nextNext;
            // 移动当前节点到交换后节点位置
            curr = next;
        }
        return dummy.next;
    }
}