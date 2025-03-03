package com.sstdl.leetcode.hot_100.hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SSTDL
 * @description 1. 两数之和
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 * 你可以按任意顺序返回答案。
 *
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 *
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 */
public class twoSum_easy_1 {
    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{2, 7, 11, 15}, 26);
        for (int i : ints) {
            System.out.println(i);
        }
    }

    // 哈希表-AC
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int index[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            // nums[i] = firstNum
            // target - nums[i] = secondNum
            // 如果map中存在secondNum，则返回secondNum的索引
            if (map.containsKey(target - nums[i])) {
                index[0] = map.get(target - nums[i]);
                index[1] = i;
                break;
            } else {
                // 将数字加入进map中
                map.put(nums[i], i);
            }
        }
        return index;
    }

    // 遍历-AC
    // 目标数减去第一个数就为第二个数
    // 依次进行两次遍历即可
//    public static int[] twoSum(int[] nums, int target) {
//        int firstNum = 0, secondNum = 0;
//        int index[] = new int[2];
//        for (int i = 0; i < nums.length; i++) {
//            firstNum = nums[i];
//            secondNum = target - firstNum;
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[j] == secondNum) {
//                    index[0] = i;
//                    index[1] = j;
//                }
//            }
//        }
//        return index;
//    }
}
