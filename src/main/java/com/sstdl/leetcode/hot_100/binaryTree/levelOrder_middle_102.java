package com.sstdl.leetcode.hot_100.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author SSTDL
 * @description 102. 二叉树的层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 *
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 *
 * 示例 2：
 * 输入：root = [1]
 * 输出：[[1]]
 *
 * 示例 3：
 * 输入：root = []
 * 输出：[]
 */
public class levelOrder_middle_102 {
    // 不需要使用额外空间-AC（手撕）
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            // 记录下来当前队列的大小，遍历这一层
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                // 添加新层
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(list);
        }
        return result;
    }

    // 使用队列存储节点-AC（手撕）
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        if (root == null) return new ArrayList<>();
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        List<List<Integer>> result = new ArrayList<>();
//        while (!queue.isEmpty()) {
//            List<Integer> list = new ArrayList<>();
//            List<TreeNode> listTree = new ArrayList<>();
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                // 存储每一层的节点
//                TreeNode node = queue.poll();
//                listTree.add(node);
//                // 记录每个节点的值
//                list.add(node.val);
//            }
//            int sizeTree = listTree.size();
//            for (int i = 0; i < sizeTree; i++) {
//                TreeNode node = listTree.get(i);
//                // 存储下一层
//                if(node.left != null) queue.add(node.left);
//                if(node.right != null) queue.add(node.right);
//            }
//            // 存储每一层的节点值
//            result.add(list);
//        }
//        return result;
//    }
}
