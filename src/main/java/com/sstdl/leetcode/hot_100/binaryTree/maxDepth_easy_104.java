package com.sstdl.leetcode.hot_100.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author SSTDL
 * @description 104. 二叉树的最大深度
 * 给定一个二叉树 root ，返回其最大深度。
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 *
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：3
 *
 * 示例 2：
 * 输入：root = [1,null,2]
 * 输出：2
 */
public class maxDepth_easy_104 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(maxDepth(root));
    }

    // 迭代法-AC（看解）
    // 广度优先搜索，BFS
    // 利用队列逐层遍历节点，每遍历完一层，深度加1，直到所有层处理完毕
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // 依次遍历每一层
        while (!queue.isEmpty()) {
            // 记录下这一层的节点数
            int size = queue.size();
            depth++;
            // 遍历这一层
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return depth;
    }

    // 递归法-AC（看解）
//    public static int maxDepth(TreeNode root) {
//        if (root == null) return 0;
//        // 取左右子树深度的较大值，加上当前节点自身的深度（+1）
//        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
//    }
}
