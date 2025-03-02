package com.practice.leetcode.hot_100.subString;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author SSTDL
 * @description
 */
public class maxSlidingWindow_hard {
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
