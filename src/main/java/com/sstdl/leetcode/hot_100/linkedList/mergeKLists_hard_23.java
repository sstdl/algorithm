package com.sstdl.leetcode.hot_100.linkedList;

import java.util.PriorityQueue;

/**
 * @author SSTDL
 * @description 23. 合并 K 个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * 示例 1：
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * <p>
 * 示例 2：
 * 输入：lists = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：lists = [[]]
 * 输出：[]
 */
public class mergeKLists_hard_23 {
    public static void main(String[] args) {
        int[] nums1 = {1,4,5};
        int[] nums2 = {1,3,4};
        int[] nums3 = {2,6};
        ListNode l1 = ListNodeUtils.createListNode(nums1);
        ListNode l2 = ListNodeUtils.createListNode(nums2);
        ListNode l3 = ListNodeUtils.createListNode(nums3);
        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = l1;
        listNodes[1] = l2;
        listNodes[2] = l3;
        ListNode listNode = mergeKLists(listNodes);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    // 使用优先队列-AC（手撕）
    // 重新记录排序后的值，再依次插入
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (ListNode list : lists) {
            if (list != null) {
                ListNode curr = list;
                while (curr != null) {
                    pq.add(curr.val);
                    curr = curr.next;
                }
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode newCurr = dummy;
        while (!pq.isEmpty()) {
            newCurr.next = new ListNode(pq.poll());
            newCurr = newCurr.next;
        }
        return dummy.next;
    }
}
