package com.sstdl.leetcode.hot_100.linkedList;

/**
 * @author SSTDL
 * @description 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例 1：
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 * 示例 2：
 * 输入：l1 = [], l2 = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 */
public class mergeTwoLists_easy_21 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,4};
        int[] nums2 = {1,3,4};
        ListNode list1 = ListNodeUtils.createListNode(nums1);
        ListNode list2 = ListNodeUtils.createListNode(nums2);
        ListNode listNode = mergeTwoLists(list1, list2);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    // 比大小后拼接新链表-AC（手撕+看解）
    //
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        // 需要确保 head 是最小的节点
        ListNode head;
        if (list1.val < list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }
        //  cur 指向头结点，接下来用于拼接剩余部分
        ListNode cur = head;
        while (list1 != null && list2 != null) {
            // 将当前较小的 list 节点接到 cur.next
            // 后 list 前进
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            // cur 前进
            cur = cur.next;
        }
        // 处理剩余的链表部分，由于链表是有序的，剩余部分直接拼接到 cur.next 即可
        cur.next = list1 == null ? list2 : list1;
        return head;
    }
}
