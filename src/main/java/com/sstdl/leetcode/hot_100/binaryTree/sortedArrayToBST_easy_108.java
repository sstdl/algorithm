package com.sstdl.leetcode.hot_100.binaryTree;

/**
 * @author SSTDL
 * @description 108. 将有序数组转换为二叉搜索树
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 平衡 二叉搜索树。
 *
 * 示例 1：
 * 输入：nums = [-10,-3,0,5,9]
 * 输出：[0,-3,9,-10,null,5]
 * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
 *
 * 示例 2：
 * 输入：nums = [1,3]
 * 输出：[3,1]
 * 解释：[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树。
 */
public class sortedArrayToBST_easy_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        if (len == 0) return null;
        return BinaryTree(nums, 0, len - 1);
    }

    // 递归法-AC（手撕）
    public TreeNode BinaryTree(int[] nums, int left, int right) {
        // 递归终止条件
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        // 将中间节点作为根节点
        TreeNode root = new TreeNode(nums[mid]);
        // 依次递归
        root.left = BinaryTree(nums, left, mid - 1);
        root.right = BinaryTree(nums, mid + 1, right);
        return root;
    }
}