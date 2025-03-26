package com.sstdl.leetcode.hot_100.binaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SSTDL
 * @description 114. 二叉树展开为链表
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 * 示例 1：
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 *
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：root = [0]
 * 输出：[0]
 */
public class flatten_middle_114 {

    // 记录遍历顺序，重新填充二叉树-AC
    public void flatten(TreeNode root) {
        if (root == null) return;
        List<TreeNode> list = new ArrayList<>();
        dfs(root, list);
        // 重建树
        for(int i = 1; i < list.size(); i++){
            TreeNode pre = list.get(i - 1);
            TreeNode cur = list.get(i);
            pre.left = null;
            pre.right = cur;
        }
    }
    public void dfs(TreeNode root, List<TreeNode> list) {
        if (root == null) return;
        // 先序遍历
        list.add(root);
        dfs(root.left, list);
        dfs(root.right, list);
    }

    // 优化：原地修改树结构，不适用额外的空间
    public void flatten2(TreeNode root) {
        if(root == null) return;
        flatten2(root.left);
        flatten2(root.right);

        TreeNode right = root.right;
        root.right = root.left;
        root.left = null;

        TreeNode cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }
        cur.right = right;
    }
}
