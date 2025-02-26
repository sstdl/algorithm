package com.practice.leetcode.hot_100.doublePointers;

/**
 * @author SSTDL
 * @description
 */
public class trap_hard {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    // 动态规划-AC
    // 求出每个位置左右的最大值，然后求出每个位置可放置的水量
    // 时间复杂度O(n) 依次累加
    public static int trap(int[] height) {
        int res = 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        leftMax[0] = height[0];
        rightMax[height.length - 1] = height[height.length - 1];
        // 记录每个数左边的最大值
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }
        // 记录每个数右边的最大值
        for (int i = height.length - 2; i >= 1; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }

        for (int i = 0; i < height.length; i++) {
            int min = Math.min(leftMax[i], rightMax[i]);
            if (min > height[i]) {
                res += min - height[i];
            }
        }
        return res;
    }

    // 暴力解法-AC
    // 按列求解，每列求出上方可放置多少水
    // 时间复杂度O(n^2) 依次累加
//    public static int trap(int[] height) {
//        int res = 0;
//        for (int i = 1; i < height.length - 1; i++) {
//            int leftMax = 0;
//            int rightMax = 0;
//            for (int j = i - 1; j >= 0; j--) { // 左边最大值
//                leftMax = Math.max(leftMax, height[j]);
//            }
//            for (int j = i + 1; j < height.length; j++) { // 右边最大值
//                rightMax = Math.max(rightMax, height[j]);
//            }
//            if (Math.min(leftMax, rightMax) > height[i]) {
//                // 每列的水等于左右两边最大高度的较小值减去当前列的高度
//                res += Math.min(leftMax, rightMax) - height[i];
//            }
//        }
//        return res;
//    }

    // 暴力解法-TLE
    // 逐层判断是否有空余点位
    // 依次累加即可 时间复杂度O(mn)
//    public static int trap(int[] height) {
//        int max = 0;
//        int maxHeight = 0;
//        for (int i : height) {
//            maxHeight = Math.max(maxHeight, i);
//        }
//        int perHeight = 1;
//        while (perHeight < maxHeight) {
//            List<Integer> list = new ArrayList<>();
//            for (int i = 0; i < height.length; i++) {
//                if (height[i] > perHeight) {
//                    list.add(i);
//                }
//            }
//            for (int i = 0; i < list.size() - 1; i++) {
//                max += list.get(i + 1) - list.get(i) - 1;
//            }
//            perHeight++;
//        }
//        return max;
//    }
}