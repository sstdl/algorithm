package com.sstdl.leetcode.hot_100.linkedList;

/**
 * @author SSTDL
 * @description 2. 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例 1：
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * <p>
 * 示例 2：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * <p>
 * 示例 3：
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 */
public class addTwoNumbers_middle_2 {
    public static void main(String[] args) {
        int[] nums1 = {2,4,3};
        int[] nums2 = {5,6,4};
        ListNode l1 = ListNodeUtils.createListNode(nums1);
        ListNode l2 = ListNodeUtils.createListNode(nums2);
        ListNode listNode = addTwoNumbers(l1, l2);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

    // 优化后-AC
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int flag = 0; // 用于表示进位
        ListNode head = null;  // 新链表的头节点
        ListNode cur = null;   // 当前节点，用于遍历新链表

        // 定义一个函数来处理节点的加法，避免重复代码
        while (l1 != null || l2 != null || flag != 0) {
            int sum = flag; // 先加上进位
            if (l1 != null) {
                sum += l1.val; // 如果 l1 有节点，加上 l1 节点的值
                l1 = l1.next;  // 移动 l1
            }
            if (l2 != null) {
                sum += l2.val; // 如果 l2 有节点，加上 l2 节点的值
                l2 = l2.next;  // 移动 l2
            }
            flag = sum / 10; // 计算进位
            sum = sum % 10;  // 计算当前节点的值
            // 创建新节点并链接到链表
            if (head == null) {
                head = new ListNode(sum);  // 第一个节点直接赋值给头节点
                cur = head;                // 当前节点也指向头节点
            } else {
                cur.next = new ListNode(sum);  // 否则，添加新节点
                cur = cur.next;                // 移动到下一个节点
            }
        }
        return head;
    }

    // 数字拆分-AC（手撕）
    // 拆解每一个数字后，计算有没有进位
    // 逐个相加（待优化，有很多重复逻辑）
//    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        int flag = 0;
//        int sum = l1.val + l2.val;
//        if (sum < 10) {
//            flag = 0;
//        } else {
//            flag = 1;
//        }
//        l1 = l1.next;
//        l2 = l2.next;
//        ListNode head = new ListNode(sum % 10);
//        ListNode cur = head;
//
//        while (l1 != null && l2 != null) {
//            sum = l1.val + l2.val + flag;
//            if (sum < 10) {
//                flag = 0;
//            } else {
//                flag = 1;
//            }
//            cur.next = new ListNode(sum % 10);
//            cur = cur.next;
//            l1 = l1.next;
//            l2 = l2.next;
//        }
//
//        while (l1 != null) {
//            sum = l1.val + flag;
//            if (sum < 10) {
//                flag = 0;
//            } else {
//                flag = 1;
//            }
//            cur.next = new ListNode(sum % 10);
//            cur = cur.next;
//            l1 = l1.next;
//        }
//
//        while (l2 != null) {
//            sum = l2.val + flag;
//            if (sum < 10) {
//                flag = 0;
//            } else {
//                flag = 1;
//            }
//            cur.next = new ListNode(sum % 10);
//            cur = cur.next;
//            l2 = l2.next;
//        }
//        if (flag == 1) {
//            cur.next = new ListNode(1);
//        }
//
//        return head;
//    }

    // 转换为int类型相加后再拆分-ERROR（过部分样例）
    // 超出int最大范围限制
//    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        int num1 = 0, num2 = 0;
//        int multiply = 1;
//        while (l1 != null) {
//            num1 += l1.val * multiply;
//            l1 = l1.next;
//            multiply *= 10;
//        }
//        System.out.println(num1);
//        multiply = 1;
//        while (l2 != null) {
//            num2 += l2.val * multiply;
//            l2 = l2.next;
//            multiply *= 10;
//        }
//        System.out.println(num2);
//        int res = num1 + num2;
//        System.out.println(res);
//        ListNode head = new ListNode(res % 10);
//        res /= 10;
//        ListNode cur = head;
//        while (res > 0) {
//            int num = res % 10;
//            cur.next = new ListNode(num);
//            cur = cur.next;
//            res = res / 10;
//        }
//        return head;
//    }
}
