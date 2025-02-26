package com.practice.leetcode.hot_100.hashTable;

import java.util.*;

/**
 * @author SSTDL
 * @description
 */
public class longestConsecutive_middle {
    public static void main(String[] args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        int i = longestConsecutive(nums);
        System.out.println(i);
    }

//    哈希表
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
}
