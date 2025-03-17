package com.sstdl.leetcode.hot_100.linkedList;

/**
 * @author SSTDL
 * @description 148. 排序链表
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * <p>
 * 示例 1：
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * <p>
 * 示例 2：
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * <p>
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 */
public class sortList_middle_148 {
    public static void main(String[] args) {
        int[] nums = {4, 2, 1, 3, 4};
        ListNode head = ListNodeUtils.createListNode(nums);
        ListNode listNode = sortList(head);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    // 归并排序-AC（看解）
    // Time-O(n log n)  Space-O(n)
    public static ListNode sortList(ListNode head) {
        // 递归终止条件
        if (head == null || head.next == null) return head;
        // 分割链表
        ListNode middle = findMiddle(head);
        // 从left到middle
        ListNode left = head;
        // 从right到末尾
        ListNode right = middle.next;
        // 切断两个链表
        middle.next = null;

        left = sortList(left);
        right = sortList(right);
        return merge(left, right);
    }

    // 快指针到达链表末尾时，慢指针刚好到链表一半的位置
    public static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 合并链表
    public static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

    // 使用优先队列-AC（手撕）
    // 时间复杂度 O(n log n) 空间复杂度 O(n)
    // 允许重复元素且自动排序的数据结构，优先队列存储所有元素
//    public static ListNode sortList(ListNode head) {
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        ListNode cur = head;
//        while (cur != null) {
//            pq.add(cur.val);
//            cur = cur.next;
//        }
//        ListNode newHead = new ListNode(0);
//        ListNode newCur = newHead;
//        while (!pq.isEmpty()) {
//            newCur.next = new ListNode(pq.poll());
//            newCur = newCur.next;
//        }
//        return newHead.next;
//    }
}
