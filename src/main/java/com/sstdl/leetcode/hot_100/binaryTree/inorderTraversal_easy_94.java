package com.sstdl.leetcode.hot_100.binaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author SSTDL
 * @description 94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 *
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 *
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 */
public class inorderTraversal_easy_94 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> list = inorderTraversal(root);
        System.out.println(list);
    }

    // 迭代法-AC（看解）
    // 使用双端队列模拟栈
    // 访问顺序为 左-根-右
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        // cur 为空 或者 stack 为空
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                // 左子节点入栈
                stack.push(cur);
                // 移动指针到左子节点
                cur = cur.left;
            }
            // cur 此时为 null，说明左子树已经遍历到底
            // 弹出栈顶
            cur = stack.pop();
            // 访问栈顶并记录
            list.add(cur.val);
            // 访问右子树
            cur = cur.right;
        }
        return list;
    }

    // 递归法-AC（看解）
    // 中序遍历（顺序是左子树、根节点、右子树）
    // 递归处理每个子节点
//    public static List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        traversal(list, root);
//        return list;
//    }
//
//    public static void  traversal (List<Integer> list, TreeNode node) {
//        if (node == null) return;
//        // 先遍历左子节点
//        traversal(list, node.left);
//        // 访问当前节点
//        list.add(node.val);
//        // 在遍历右子节点
//        traversal(list, node.right);
//    }
}
