package com.sstdl.leetcode.hot_100.generalArray;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author SSTDL
 * @description 56. 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 * 示例 1：
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 示例 2：
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class merge_middle_56 {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 2}, {3, 10}, {5, 6}, {7, 11}};
        int[][] merge = merge(intervals);
        System.out.println(Arrays.deepToString(merge));
    }

    // 二维数组排序后，依次比较后添加-AC
    // 时间复杂度：O(nlogn)
    public static int[][] merge(int[][] intervals) {
        // 按照区间起点排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int start = intervals[0][0], end = intervals[0][1];
        // 使用 ArrayList 存储动态扩容的区间，避免 [0, 0] 问题
        ArrayList<int[]> merged = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                // 更新 end，保证区间正确合并
                end = Math.max(end, intervals[i][1]);
            } else {
                // 无重叠，存入当前区间
                merged.add(new int[]{start, end});
                // 更新 start 和 end
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        // 添加最后一个合并区间
        merged.add(new int[]{start, end});
        return merged.toArray(new int[merged.size()][]);
    }
}
