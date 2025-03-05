package com.sstdl.leetcode.hot_100.matrix;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author SSTDL
 * @description 73. 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 * 示例 1：
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 *
 * 示例 2：
 * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 */
public class setZeroes_middle_73 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    // 存储出现零的行和列（手撕）-AC
    // 时间复杂度o（mn）
    // 遍历行和列，将元素重置为零
    public static void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for (Integer row : rows) {
            for (int i = 0; i < colLen; i ++) {
                matrix[row][i] = 0;
            }
        }
        for (Integer col : cols) {
            for (int i = 0; i < rowLen; i ++) {
                matrix[i][col] = 0;
            }
        }
    }
}
