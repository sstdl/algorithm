package com.practice.leetcode.hot_100.subString;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SSTDL
 * @description
 */
public class subarraySum_middle {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int k = 3;
        int i = subarraySum(nums, k);
        System.out.println(i);
    }

    public static int subarraySum(int[] nums, int k) {
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;
        int count = 0;
        // 用哈希表记录每个前缀和出现的次数
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
