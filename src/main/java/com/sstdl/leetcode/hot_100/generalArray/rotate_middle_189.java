package com.sstdl.leetcode.hot_100.generalArray;

/**
 * @author SSTDL
 * @description 189. 轮转数组
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 *
 * 示例 2:
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 */
public class rotate_middle_189 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums, k);
    }

    // 反转数组-AC
    // 空间复杂度为O(1)，原地修改数组，不需要额外空间
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        // 依次交换第一个和最后一个元素
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // 使用额外数组-AC
    // 空间复杂度为 O(n)
//    public static void rotate(int[] nums, int k) {
//        int n = nums.length;
//        int[] temp = new int[n];
//        // 对 k 取模，防止越界问题
//        k = k%n;
//
//        if (k == 0) return; // k 为 0 时无需旋转
//        for (int i = 0; i < n; i++) {
//            temp[(i + k) % n] = nums[i]; // 直接计算新索引位置
//        }
//
////        for (int i = k; i < n; i++) {
////            temp[i] = nums[i - k];
////        }
////        for (int i = 0; i < k; i++) {
////            if (n - k + i < 0) {
////                break;
////            }
////            temp[i] = nums[n - k + i];
////        }
//
//        for (int i = 0; i < n; i++) {
//            nums[i] = temp[i];
//        }
//    }
}
