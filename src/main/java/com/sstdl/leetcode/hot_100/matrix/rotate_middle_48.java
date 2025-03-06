package com.sstdl.leetcode.hot_100.matrix;

/**
 * @author SSTDL
 * @description 48. 旋转图像
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 * <p>
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 * <p>
 * 示例 2：
 * 输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * 输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 */
public class rotate_middle_48 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix);
    }

    // 水平翻转+对角线反转-AC（看解）
    // 不使用额外数组
    // 还有一种做法是原地旋转，想不到做法
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        // 水平翻转（只用翻转一半的行）
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = temp;
            }
        }
        // 对角线翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    // 使用额外数组-AC（手撕）
    // 找规律进行赋值
//    public static void rotate(int[][] matrix) {
//        int n = matrix.length;
//        int[][] newMatrix = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                newMatrix[i][j] = matrix[n - j - 1][i];
//            }
//        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                matrix[i][j] = newMatrix[i][j];
//            }
//        }
//        System.out.println(Arrays.deepToString(matrix));
//    }
}
