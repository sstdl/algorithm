package com.sstdl.leetcode.hot_100.linkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SSTDL
 * @description 146. LRU 缓存
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 * 示例：
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 */
public class LRUCache_middle_146 {
    // 双向链表+哈希表-AC（看解）
    public class LRUCache {

        class LinkedNode {
            int key;
            int value;
            LinkedNode prev;
            LinkedNode next;

            public LinkedNode() {
            }

            public LinkedNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private Map<Integer, LinkedNode> map;
        private int capacity;
        private LinkedNode dummyHead;
        private LinkedNode dummyTail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();
            // 创建初始虚拟节点，方便处理边界问题
            dummyHead = new LinkedNode(-1, -1);
            dummyTail = new LinkedNode(-1, -1);
            dummyHead.next = dummyTail;
            dummyTail.prev = dummyHead;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            LinkedNode node = map.get(key);
            deleteNode(node);
            moveToTail(node);
            return node.value;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                // 更新值
                LinkedNode linkedNode = map.get(key);
                linkedNode.value = value;
                // 移除该节点，并移动到末尾
                deleteNode(linkedNode);
                moveToTail(linkedNode);
            } else {
                // 添加值
                LinkedNode linkedNode = new LinkedNode(key, value);
                map.put(key, linkedNode);
                moveToTail(linkedNode);
                if (map.size() > capacity) {
                    // 超出容量限制，移除头结点
                    LinkedNode head = dummyHead.next;
                    deleteNode(head);
                    map.remove(head.key);
                }
            }

        }

        // 移除节点
        private void deleteNode(LinkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        // 移动节点到末尾
        private void moveToTail(LinkedNode node) {
            node.next = dummyTail;
            node.prev = dummyTail.prev;
            dummyTail.prev.next = node;
            dummyTail.prev = node;
        }
    }

}
