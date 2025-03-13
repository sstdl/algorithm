package com.sstdl.leetcode.hot_100.linkedList;

/**
 * @author SSTDL
 * @description 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * <p>
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 */
public class removeNthFromEnd_middle_19 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        int n = 1;
        ListNode head = ListNodeUtils.createListNode(nums);
        ListNode listNode = removeNthFromEnd(head, n);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    // 双指针一次遍历-AC（看解）
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 添加虚拟头节点，简化删除头节点的逻辑，所有节点都变成“中间节点”
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;  // 快指针
        ListNode slow = dummy;  // 慢指针

        // 快指针先移动 n+1 步（因为虚拟头节点占位）
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // 快慢指针同时移动，直到快指针到达链表末尾
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 此时慢指针指向要删除节点的前一个节点
        slow.next = slow.next.next;

        return dummy.next;  // 返回真正的头节点
    }

    // 遍历跳过-AC（手撕 + 部分解）
    // 两次遍历
//    public static ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode cur = head;
//        int count = 0;
//        // 计算链表长度
//        while (cur != null) {
//            cur = cur.next;
//            count++;
//        }
//        ListNode curr = head;
//        // 处理删除头结点的情况
//        if (count == n) {
//            return head.next;
//        }
//        int index = 1;
//        // 要删除节点的前一个位置
//        int targetIndex = count - n;
//        while (curr != null) {
//            if (index == targetIndex) {
//                // 跳过删除节点
//                curr.next = curr.next.next;
//                break;
//            }
//            index++;
//            curr = curr.next;
//        }
//        return head;
//    }
}
