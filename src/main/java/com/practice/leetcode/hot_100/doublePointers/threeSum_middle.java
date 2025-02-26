package com.practice.leetcode.hot_100.doublePointers;

import java.util.*;

/**
 * @author SSTDL
 * @description
 */
public class threeSum_middle {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1};
        List<List<Integer>> res = threeSum(nums);
        System.out.println(res.toString());
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return null;
        }
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        // 确定一个值
        // 用双指针遍历另外两个
        for (int i = 0; i < nums.length; i++) {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] + nums[i] < 0) {
                    left++;
                } else {
                    right--;
                }
                if (nums[left] + nums[right] + nums[i] == 0) {
                    // 不能重复数字
                    if (left == i || right == i || left == right) {
                        continue;
                    }
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    // 防止重复排列
                    Collections.sort(list);
                    set.add(list);
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>(set);
        return res;
    }
}
