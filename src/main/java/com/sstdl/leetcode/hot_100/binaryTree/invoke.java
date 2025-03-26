package com.sstdl.leetcode.hot_100.binaryTree;

/**
 * @author SSTDL
 * @description
 */
public class invoke {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(5);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.right.left = new TreeNode(6);
        flatten_middle_114 solution = new flatten_middle_114();
        solution.flatten(node);
    }
}
