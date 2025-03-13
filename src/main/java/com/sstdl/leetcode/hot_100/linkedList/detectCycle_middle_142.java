package com.sstdl.leetcode.hot_100.linkedList;

/**
 * @author SSTDL
 * @description 142. 环形链表 II
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 不允许修改 链表。
 * <p>
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：返回索引为 0 的链表节点
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * <p>
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：返回 null
 * 解释：链表中没有环。
 */
public class detectCycle_middle_142 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 0, -4};
        int pos = 1;
        ListNode head = ListNodeUtils.createListNode(nums);
        ListNode cycleStart = detectCycle(head);
        System.out.println("Cycle starts at node with value: " + (cycleStart != null ? cycleStart.val : "No cycle"));
    }

    // floyd（龟兔赛宝算法）-AC（看解）
    // 链表头到环入口的距离为 a
    // 环入口到快慢指针相遇点的距离为 b
    // 环的总长度为 c
    //
    // 1.找到相遇点，在相遇时，fast 走的总步数是 slow 的两倍
    // Dist(fast) = 2 * Dist(slow) =2 * (a + b)
    // fast 比 slow 多走了整圈的整数倍
    // 则 2(a + b) = a + b + n * c  --->  a + b = n * c
    //
    // 2. 找到环入口
    // b 这个距离等价于 “从相遇点再走 a 步后就会到达环入口”
    // 让一个指针从 head 开始走 a 步，另一个指针从 slow（相遇点）开始走 a 步，它们必定在环入口相遇
    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 快慢指针最终相遇，说明有环
            if (slow == fast) {
                ListNode temp = head;
                while (temp != slow) {
                    temp = temp.next;
                    slow = slow.next;
                }
                return temp;
            }
        }
        return null;
    }
}


