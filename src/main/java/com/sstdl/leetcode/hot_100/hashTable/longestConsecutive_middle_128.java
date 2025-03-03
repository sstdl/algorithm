package com.sstdl.leetcode.hot_100.hashTable;

import java.util.*;

/**
 * @author SSTDL
 * @description 128. 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * 示例 1：
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * 示例 2：
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 *
 * 示例 3：
 * 输入：nums = [1,0,1,2]
 * 输出：3
 */
public class longestConsecutive_middle_128 {
    public static void main(String[] args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        int i = longestConsecutive(nums);
        System.out.println(i);
    }

    // 使用哈希表存储-AC
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int start : set) {
            // 以 start−1 为起点计算出的序列长度，一定比以 start 为起点计算出的序列长度要长
            // 所以只需要以 start 为起点计算一次即可
            if (set.contains(start - 1)) {
                continue;
            }
            int end = start + 1;
            // 1 2 3 4 中只有 1 进入内层循环
            while (set.contains(end)) {
                end++;
            }
            max = Math.max(max, end - start);
        }
        return max;
    }


//    哈希表-AC
//    设置一个键为数字，值为连续数最大值的map
//    最开始时将未出现和没有相邻数字的值 都置为1
//    核心时当该数字出现相邻数字时，将该数字的次数进行统计
//    统计比他大一位和小一位的数字的乡邻次数
//    最后返回最大值
//    public static int longestConsecutive(int[] nums) {
//        Arrays.sort(nums);
//        Map<Integer, Integer> map = new HashMap<>();
//        int max = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (map.containsKey(nums[i] + 1) || map.containsKey(nums[i] - 1)) {
//                map.put(nums[i], map.getOrDefault(nums[i] + 1, 1) + map.getOrDefault(nums[i] - 1, 1));
//            } else {
//                map.put(nums[i], 1);
//            }
//        }
//        for (Integer value : map.values()) {
//            max = Math.max(max, value);
//        }
//        return max;
//    }
}
