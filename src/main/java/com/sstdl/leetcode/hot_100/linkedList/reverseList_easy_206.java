package com.sstdl.leetcode.hot_100.linkedList;

/**
 * @author SSTDL
 * @description 206. 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * <p>
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：[2,1]
 * <p>
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 */
public class reverseList_easy_206 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = ListNodeUtils.createListNode(nums);
        ListNode listNode = reverseList(head);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    // 迭代法-AC（看解）
    // head -> 1 -> 2 -> 3 -> 4 -> 5 -> null
    // 第一轮
    // prev = null
    // cur = 1, nextNode = 2
    // 1.nextNode -> null  （指向 prev）
    // prev = 1
    // cur = 2
    // 结果
    // 1 -> null
    // 2 -> 3 -> 4 -> 5 -> null
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            // 记录下一个节点
            ListNode nextNode = cur.next;
            // 翻转节点
            cur.next = prev;
            // 移动 prev 指针
            prev = cur;
            // 移动 cur 指针
            cur = nextNode;
        }
        return prev;
    }
}


