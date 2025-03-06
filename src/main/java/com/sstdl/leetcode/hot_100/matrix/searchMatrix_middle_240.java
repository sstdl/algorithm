package com.sstdl.leetcode.hot_100.matrix;

/**
 * @author SSTDL
 * @description 240. 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * <p>
 * 示例 1：
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * 输出：false
 */
public class searchMatrix_middle_240 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7, 9}, {2, 4, 6, 8, 10}, {11, 13, 15, 17, 19}, {12, 14, 16, 18, 20}, {21, 22, 23, 24, 25}};
        int target = 13;
        boolean b = searchMatrix(matrix, target);
        System.out.println(b);
    }

    // Z 字形查找-AC（看解）
    // 时间复杂度o(m+n)
    // 从右上角开始（matrix[0][n-1]），它是当前行的最大值，当前列的最小值，决定下一步是左移还是下移
    // 或者从左上角开始，也可以
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int row = 0, col = n - 1;
        while (row < m && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            }
            if (matrix[row][col] > target) {
                // 当前值太大，去掉该列
                col--;
            } else {
                // 当前值太大，去掉该行
                row++;
            }
        }
        return false;
    }

    // 根据矩阵特性-ERROR（手撕）
    // 遍历一个矩形的圈
    // 可能会跳过目标元素所在行和列，从而找不到正确的结果
//    public static boolean searchMatrix(int[][] matrix, int target) {
//        int m = matrix.length, n = matrix[0].length;
//        int col = n - 1, row = m - 1;
//        for (int i = 0; i < n; i++) {
//            if (matrix[0][i] == target) {
//                return true;
//            } else if (matrix[0][i] > target) {
//                col = i - 1;
//                break;
//            }
//        }
//        if (col < 0) {
//            return false;
//        }
//        for (int i = 0; i < m; i++) {
//            if (matrix[i][0] == target) {
//                return true;
//            } else if (matrix[i][0] > target) {
//                row = i - 1;
//                break;
//            }
//        }
//        if (row < 0) {
//            return false;
//        }
//        for (int i = 0; i < n; i++) {
//            if (matrix[row][i] == target) {
//                return true;
//            }
//        }
//        for (int i = 0; i < m; i++) {
//            if (matrix[i][col] == target) {
//                return true;
//            }
//        }
//        return false;
//    }

    // 暴力遍历-AC（手撕）
    // 时间复杂度o（n^2）
//    public static boolean searchMatrix(int[][] matrix, int target) {
//        int m = matrix.length;
//        int n = matrix[0].length;
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (matrix[i][j] == target) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
}
