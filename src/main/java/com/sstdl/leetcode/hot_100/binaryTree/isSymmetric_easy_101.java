package com.sstdl.leetcode.hot_100.binaryTree;

/**
 * @author SSTDL
 * @description
 */
public class isSymmetric_easy_101 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        boolean symmetric = isSymmetric(root);
        System.out.println(symmetric);
    }

    // 迭代法-AC
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    public static boolean isMirror(TreeNode left, TreeNode right) {
        // 同时为 null
        if (left == null && right == null) return true;
        // 结构不对称
        if (left == null || right == null) return false;
        // 值不对称
        if (left.val != right.val) return false;
        // 依次进行镜像对比迭代
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    // 使用队列记录镜像值-AC
//    public static boolean isSymmetric(TreeNode root) {
//        if (root == null) return true;
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root.left);
//        queue.offer(root.right);
//        while (!queue.isEmpty()) {
//            TreeNode left = queue.poll();
//            TreeNode right = queue.poll();
//            if (left == null && right == null) continue;
//            if (left == null || right == null) return false;
//            if (left.val != right.val) return false;
//            // 按镜像顺序成对入队
//            queue.offer(left.left);
//            queue.offer(right.right);
//            queue.offer(left.right);
//            queue.offer(right.left);
//        }
//        return true;
//    }
}