package com.sstdl.leetcode.hot_100.subString;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author SSTDL
 * @description 239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 *
 * 示例 1：
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * 示例 2：
 * 输入：nums = [1], k = 1
 * 输出：[1]
 */
public class maxSlidingWindow_hard_239 {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] ints = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(ints));
    }

    // 优先队列解法-AC
    // 时间复杂度 O(nlogn)
    // 优先队列用来记录还在当前滑动窗口中的最大值
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        // 创建一个优先队列（最大堆），用于存储每个元素和它的索引。
        // 0 索引表示元素值，1 索引表示元素下标
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[0] - o1[0] : o1[1] - o2[1];
            }
        });
        for (int i = 0; i < k; i ++ ) {
            pq.offer(new int[]{nums[i], i});
        }
        int [] max = new int[n - k + 1];
        max[0] = pq.peek()[0];
        for (int i = k; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
            // 最大值不在滑动窗口
            while (pq.peek()[1] < i - k) {
                pq.poll();
            }
            max[i - k + 1] = pq.peek()[0];
        }
        return max;
    }

    // 暴力解法-TLE
    // 遍历每个窗口，依次计算最大值并记录
//    public static int[] maxSlidingWindow(int[] nums, int k) {
//        int[] result = new int[nums.length - k + 1];
//        for (int i = 0; i < nums.length - k + 1; i++) {
//            int max = Integer.MIN_VALUE;
//            for (int j = i; j < i + k; j++) {
//                max = Math.max(max, nums[j]);
//            }
//            result[i] = max;
//        }
//
//        return result;
//    }
}
