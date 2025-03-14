package com.sstdl.leetcode.hot_100.linkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SSTDL
 * @description 138. 随机链表的复制
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 * 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。
 * 新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。
 * 复制链表中的指针都不应指向原链表中的节点 。
 * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
 * 返回复制链表的头节点。
 * 用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 * 你的代码 只 接受原链表的头节点 head 作为传入参数。
 *
 * 示例 1：
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 * 示例 2：
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 *
 * 示例 3：
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 */
public class copyRandomList_middle_138 {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        Node node = copyRandomList(head);
    }

    // 使用 map 存储映射关系-AC（看解）
    public static Node copyRandomList(Node head) {
        Node dummy = new Node(0);
        Node cur = dummy;
        Node oldNode = head;
        // 需要建立原节点到新节点的映射关系
        Map<Node, Node> map = new HashMap<>();
        while (oldNode != null) {
            Node newNode = new Node(oldNode.val);
            // 保存映射关系
            map.put(oldNode, newNode);
            cur.next = newNode;
            cur = cur.next;
            oldNode = oldNode.next;
        }

        oldNode = head;
        Node newCur = dummy.next;
        while (oldNode != null) {
            // 重新匹配 random 节点
            newCur.random = map.get(oldNode.random);
            newCur = newCur.next;
            oldNode = oldNode.next;
        }
        return dummy.next;
    }

    // 还是直接复制了原链表，没有深拷贝-ERROR
//    public static Node copyRandomList(Node head) {
//        Node newHead = new Node(-1);
//        Node cur = head;
//        Node newCur = newHead;
//        while (cur != null) {
//            newCur.next = new Node(cur.val);
//            newCur.random = cur.random; // 直接复制原链表指针
//            newCur = newCur.next;
//            cur = cur.next;
//        }
//        return newHead.next;
//    }
}
