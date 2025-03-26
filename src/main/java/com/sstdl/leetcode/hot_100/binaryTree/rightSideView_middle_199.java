package com.sstdl.leetcode.hot_100.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author SSTDL
 * @description 199. 二叉树的右视图
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例 1：
 * 输入：root = [1,2,3,null,5,null,4]
 * 输出：[1,3,4]
 *
 * 示例 2：
 * 输入：root = [1,2,3,4,null,null,null,5]
 * 输出：[1,3,4,5]
 *
 * 示例 3：
 * 输入：root = [1,null,3]
 * 输出：[1,3]
 *
 * 示例 4：
 * 输入：root = []
 * 输出：[]
 */
public class rightSideView_middle_199 {
    // 层序遍历-AC（手撕）
    // 记录每一层的节点，从右边开始添加
    // 返回列表中第一个节点的值
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> res = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node);
                // 从右边开始添加
                if (node.right != null) queue.add(node.right);
                if (node.left != null) queue.add(node.left);
            }
            // 添加元素
            res.add(list.get(0).val);
        }
        return res;
    }

    // 优化思路: DFS
    // 先访问右子树的 DFS（根 右 左）
    // 第一次到达某一深度，该节点就是该层最右节点
    public List<Integer> rightSideViewByDFS(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        dfs(root, res, 0);
        return res;
    }
    public void dfs(TreeNode root, List<Integer> res, int depth){
        if (root == null) return;
        if(depth == res.size()) res.add(root.val);
        // 先访问右子树
        dfs(root.right,res, depth + 1);
        dfs(root.left,res, depth + 1);
    }
}
