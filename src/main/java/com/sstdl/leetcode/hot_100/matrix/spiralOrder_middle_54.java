package com.sstdl.leetcode.hot_100.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SSTDL
 * @description 54. 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * <p>
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class spiralOrder_middle_54 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        List<Integer> list = spiralOrder(matrix);
        System.out.println(list);
    }

    // 模拟旋转（手撕+部分看解）-AC
    public static List<Integer> spiralOrder(int[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        List<Integer> list = new ArrayList<Integer>();
        // 列索引
        int left = 0, right = colLen - 1;
        // 行索引
        int up = 0, down = rowLen - 1;
        while (right >= left && down >= up) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[up][i]);
            }
            // 上边界 + 1
            up++;
            for (int i = up; i <= down; i++) {
                list.add(matrix[i][right]);
            }
            // 右边界 - 1
            right--;
            if (up <= down) {
                for (int i = right; i >= left; i--) {
                    list.add(matrix[down][i]);
                }
                // 下边界 - 1
                down--;
            }
            if (left <= right) {
                for (int i = down; i >= up; i--) {
                    list.add(matrix[i][left]);
                }
                // 左边界 + 1
                left++;
            }
        }
        return list;
    }
}
