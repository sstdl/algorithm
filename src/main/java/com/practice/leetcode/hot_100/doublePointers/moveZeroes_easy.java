package com.practice.leetcode.hot_100.doublePointers;

import java.util.Arrays;

/**
 * @author SSTDL
 * @description
 */
public class moveZeroes_easy {
    public static void main(String[] args) {
        int[] nums = {1, 0, 0, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    // 维护一个双指针
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
