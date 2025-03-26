package com.sstdl.leetcode.hot_100.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SSTDL
 * @description 230. 二叉搜索树中第 K 小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）。
 *
 * 示例 1：
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 *
 * 示例 2：
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 */
public class kthSmallest_middle_230 {
    // 中序遍历-AC（手撕）
    // 中序遍历的顺序就是二叉搜索树的排序顺序（升序）
    // 从中找到第 k 个就可以
    // 优化思路：只遍历前 k 个节点，要是k很小的话时间复杂度就比较低
    public int kthSmallest(TreeNode root, int k) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        traversal(root, list);
        for (int i = 0; i < list.size(); i++) {
            if (i == k - 1) {
                return list.get(i).val;
            }
        }
        return 0;
    }
    public void traversal(TreeNode root, List<TreeNode> list) {
        if (root == null) return;
        traversal(root.left, list);
        list.add(root);
        traversal(root.right, list);
    }
}
