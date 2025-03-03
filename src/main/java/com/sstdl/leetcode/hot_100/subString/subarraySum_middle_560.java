package com.sstdl.leetcode.hot_100.subString;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SSTDL
 * @description 560. 和为 K 的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 子数组是数组中元素的连续非空序列。
 *
 * 示例 1：
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 *
 * 示例 2：
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 */
public class subarraySum_middle_560 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int k = 3;
        int i = subarraySum(nums, k);
        System.out.println(i);
    }

    // 用哈希表记录每个前缀和出现的次数-AC
    public static int subarraySum(int[] nums, int k) {
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;
        int count = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        // 初始化
        countMap.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            // 计算前缀和，prefixSum 表示从数组起始位置到 nums 第 i 个数组元素的前缀和
            prefixSum[i + 1] = prefixSum[i] + nums[i];
            // prefixSum[i] - prefixSum[j] 表示 i 到 j 的部分的和
            // 要是包含前缀和减去目标值，则表示存在子串和为 k
            if (countMap.containsKey(prefixSum[i + 1] - k)) {
                count += countMap.get(prefixSum[i + 1] - k);
            }
            // 统计次数
            countMap.put(prefixSum[i + 1], countMap.getOrDefault(prefixSum[i + 1], 0) + 1);
        }
        return count;
    }

    // 直接使用前缀和-AC
//    public static int subarraySum(int[] nums, int k) {
//        int[] sum = new int[nums.length + 1];
//        sum[0] = 0;
//        int count = 0;
//        for (int i = 1; i <= nums.length; i++) {
//            // 计算前缀和
//            sum[i] = sum[i - 1] + nums[i - 1];
//        }
//        for (int j = sum.length - 1; j >= 0; j--) {
//            for (int i = 0; i < j; i++) {
//                // 后面的前缀和减去前面的前缀和 得到中间部分的子串的和
//                if (sum[j] - sum[i] == k) {
//                    count++;
//                }
//            }
//        }
//        return count;
//    }
}
