package com.sstdl.leetcode.hot_100.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author SSTDL
 * @description 226. 翻转二叉树
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 *
 * 示例 1：
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *
 * 示例 2：
 * 输入：root = [2,1,3]
 * 输出：[2,3,1]
 *
 * 示例 3：
 * 输入：root = []
 * 输出：[]
 */
public class invertTree_easy_226 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(9);
        invertTree(root);
    }

    // 迭代法-AC（看解）
    // 使用队列，交换每一层的节点
    // 再将下一层的子节点加入到队列中
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return root;
    }

    // 递归法-AC（手撕）
    // 将左子节点连接到右子树上，右子节点连接到左子树上
    // 再将最终结果连接到新的根节点上
//    public static TreeNode invertTree(TreeNode root) {
//        if (root == null) return null;
//        TreeNode newRoot = new TreeNode(root.val);
//        TreeNode left = invertTree(root.right);
//        TreeNode right = invertTree(root.left);
//        newRoot.left = left;
//        newRoot.right = right;
//        return newRoot;
//    }
}
