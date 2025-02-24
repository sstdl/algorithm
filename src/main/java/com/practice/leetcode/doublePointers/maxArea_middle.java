package com.practice.leetcode.doublePointers;

/**
 * @author SSTDL
 * @description
 */
public class maxArea_middle {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

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
