package com.sstdl.leetcode.hot_100.doublePointers;

/**
 * @author SSTDL
 * @description 11. 盛最多水的容器
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 *
 * 示例 1：
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 * 示例 2：
 * 输入：height = [1,1]
 * 输出：1
 */
public class maxArea_middle_11 {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    // 双指针-AC
    public static int maxArea(int[] height) {
        // 双指针，维护左右两边的指针
        // 每次移动高度小的那个指针
        // 计算面积
        // 更新最大面积
        int left = 0, right = height.length - 1;
        int minHeight = Math.min(height[left], height[right]);
        int max = minHeight * (right - left);
        while (left < right) {
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
            minHeight = Math.min(height[left], height[right]);
            max = Math.max(max, minHeight * (right - left));
        }
        return max;
    }
}
