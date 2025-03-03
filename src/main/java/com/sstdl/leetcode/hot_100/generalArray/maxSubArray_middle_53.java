package com.sstdl.leetcode.hot_100.generalArray;

/**
 * @author SSTDL
 * @description 53. 最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组是数组中的一个连续部分。
 *
 * 示例 1：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 *
 * 示例 2：
 * 输入：nums = [1]
 * 输出：1
 *
 * 示例 3：
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 */
public class maxSubArray_middle_53 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int i = maxSubArray(nums);
        System.out.println(i);
    }

    // 分治法（动态规划）- AC
    // dp[i] 只与 dp[i-1] 相关，可以直接用 滚动变量 代替 dp 数组
    // 时间复杂度O(n) 降低了空间复杂度
    public static int maxSubArray(int[] nums) {
        // 记录当前最大子数组和
        int curMax = nums[0];
        // 记录全局最大子数组和
        int allMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curMax = Math.max(curMax + nums[i], nums[i]);
            allMax = Math.max(allMax, curMax);
        }
        return allMax;
    }

    // 动态规划
    // 时间复杂度O(n)-AC
//    public static int maxSubArray(int[] nums) {
//        int n = nums.length;
//        int[] dp = new int[n]; // dp[i] 表示以 nums[i] 结尾的最大子数组和
//        dp[0] = nums[0]; // 以 nums[0] 结尾的最大子数组就是它自己
//        int maxSum = dp[0];
//
//        for (int i = 1; i < n; i++) {
//            // 如果前面的子数组和 dp[i-1] > 0，就加上 nums[i]，否则只取 nums[i]
//            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
//            maxSum = Math.max(maxSum, dp[i]); // 维护最大子数组和
//        }
//
//        return maxSum;
//    }

    // 使用前缀和（优化过）-AC
    // 时间复杂度O(n)
//    public static int maxSubArray(int[] nums) {
//        int n = nums.length;
//        int res = Integer.MIN_VALUE;
//        // 记录当前位置之前的最小前缀和
//        int minPrefix = 0;
//        int[] prefixSum = new int[n + 1];
//        prefixSum[0] = 0;
//        for (int i = 1; i <= n; i++) {
//            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
//        }
//        for (int i = 1; i <= n; i++) {
//            // 用当前位置前缀和减去之前最小的前缀和，即为最大
//            int maxArray = prefixSum[i] - minPrefix;
//            res = Math.max(res, maxArray);
//            // 记录当前位置之前的最小前缀和
//            minPrefix = Math.min(prefixSum[i], minPrefix);
//        }
//        return res;
//    }

    // 使用前缀和-TLE
    // 两个前缀和的差值就是中间元素的和
    // 时间复杂度O(n^2)
//    public static int maxSubArray(int[] nums) {
//        int n = nums.length;
//        int [] prefixSum = new int[n + 1];
//        int res = Integer.MIN_VALUE;
//        prefixSum[0] = 0;
//        for (int i = 1; i <= n; i++) {
//            prefixSum[i] = prefixSum[i-1] + nums[i - 1];
//        }
//        for (int i = 0; i < n + 1; i++) {
//            for (int j = i+1; j < n + 1; j++) {
//                int max = prefixSum[j] - prefixSum[i];
//                if (res < max ) {
//                    res = max;
//                }
//            }
//        }
//        return res;
//    }
}
