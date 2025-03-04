package com.sstdl.leetcode.hot_100.generalArray;

import java.util.Arrays;

/**
 * @author SSTDL
 * @description 238. 除自身以外数组的乘积
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 示例 1:
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 *
 * 示例 2:
 * 输入: nums = [-1,1,0,-3,3]
 * 输出: [0,0,9,0,0]
 *
 */
public class productExceptSelf_middle_238 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] ints = productExceptSelf(nums);
        System.out.println(Arrays.toString(ints));
    }

    // 使用左右乘积计算-AC（看解）
    // 时间复杂度o（n）
    // 左数组用来计算当前元素左边的乘积，右数组用来计算当前元素左边的乘积
    // 最后左右相乘即可
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];

        // 对于索引为 '0' 的元素，因为左侧没有元素，所以 left[0] = 1
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        // 对于索引为 'length-1' 的元素，因为右侧没有元素，所以 right[n-1] = 1
        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }

    // 使用除法-AC（手撕）
    // 时间复杂度o（n）
    // 要是有两个零及以上，就所有返回都为零
    // 只有一个零，就在零的位置算乘积，其余都为零
    // 若没有零，则用总乘积去除以对应位置元素
//    public static int[] productExceptSelf(int[] nums) {
//        int zeroCount = 0, zeroIndex = 0;
//        int multiply = 1;
//        int n = nums.length;
//        int[] res = new int[n];
//        for (int i = 0; i < n; i++) {
//            if (nums[i] == 0) {
//                zeroCount++;
//                if (zeroCount == 1) {
//                    zeroIndex = i;
//                }
//                if (zeroCount >= 2) {
//                    return res;
//                }
//            }
//            multiply *= nums[i];
//        }
//        if (zeroCount == 0) {
//            for (int i = 0; i < n; i++) {
//                res[i] = multiply / nums[i];
//            }
//        } else {
//            multiply = 1;
//            for (int i = 0; i < n; i++) {
//                if (i == zeroIndex) {
//                    continue;
//                }
//                multiply *= nums[i];
//            }
//            res[zeroIndex] = multiply;
//        }
//        return res;
//    }
}
