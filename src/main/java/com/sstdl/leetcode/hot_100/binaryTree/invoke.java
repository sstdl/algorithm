package com.sstdl.leetcode.hot_100.binaryTree;

import java.util.List;

/**
 * @author SSTDL
 * @description
 */
public class invoke {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        levelOrder_middle_102 solution = new levelOrder_middle_102();
        List<List<Integer>> lists = solution.levelOrder(root);
        System.out.println(lists);
    }
}
