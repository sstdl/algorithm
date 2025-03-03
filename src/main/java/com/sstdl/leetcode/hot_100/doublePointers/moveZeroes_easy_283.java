package com.sstdl.leetcode.hot_100.doublePointers;

import java.util.Arrays;

/**
 * @author SSTDL
 * @description 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * 示例 1:
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 示例 2:
 * 输入: nums = [0]
 * 输出: [0]
 */
public class moveZeroes_easy_283 {
    public static void main(String[] args) {
        int[] nums = {1, 0, 0, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    // 维护一个双指针-AC
    // nonZero 为非零数下标 zero为零的下标
    // 每次交换都是将非零数与零进行交换 且相对顺序没有改变
    public static void moveZeroes(int[] nums) {
        int zero = 0, nonZero = 0;
        int len = nums.length;
        while (nonZero < len) {
            if (nums[nonZero] != 0) {
                swap(nums, zero, nonZero);
                zero++;
            }
            nonZero++;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
