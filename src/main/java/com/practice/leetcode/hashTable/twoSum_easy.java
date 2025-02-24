package com.practice.leetcode.hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SSTDL
 * @description
 */
public class twoSum_easy {
    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{2, 7, 11, 15}, 26);
        for (int i : ints) {
            System.out.println(i);
        }
    }

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
}
