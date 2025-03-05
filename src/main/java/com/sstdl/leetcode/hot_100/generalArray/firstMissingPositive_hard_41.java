package com.sstdl.leetcode.hot_100.generalArray;

/**
 * @author SSTDL
 * @description 41. 缺失的第一个正数
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 *
 * 示例 1：
 * 输入：nums = [1,2,0]
 * 输出：3
 * 解释：范围 [1,2] 中的数字都在数组中。
 *
 * 示例 2：
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 解释：1 在数组中，但 2 没有。
 *
 * 示例 3：
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 * 解释：最小的正数 1 没有出现。
 */
public class firstMissingPositive_hard_41 {
    public static void main(String[] args) {
        int [] nums = {3,4,-1,1};
        int i = firstMissingPositive(nums);
        System.out.println(i);
    }

    // 利用数组自身作为哈希表（打标记）-AC（看解）
    // 时间复杂度o（n） 空间复杂度o（1）
    // 对于一个长度为 N 的数组，其中没有出现的最小正整数只能在 [1,N+1] 中。
    // 如果 [1,N] 都出现了，那么答案是 N+1，否则答案是 [1,N] 中没有出现的最小正整数
    // 对数组进行遍历，对于遍历到的数 x，如果它在 [1,N] 的范围内，那么就将数组中的第 x−1 个位置（注意：数组下标从 0 开始）打上「标记」
    // 在遍历结束之后，如果所有的位置都被打上了标记，那么答案是 N+1，否则答案是最小的没有打上标记的位置加 1
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                // 均转换为正数
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            // 确保获取 nums[i] 的原始数值
            int num = Math.abs(nums[i]);
            if (num <= n) {
                // num - 1 就是 num 这个数在正整数数组中正常的下标
                // 标记数组中出现的正整数，确保无论 nums[num - 1] 是正数还是负数，都变成负数
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }

    // HashSet 存储数字-AC（手撕）
    // 时间复杂度o（n） 空间复杂度o（n）
    // 将数组所有的数放入哈希表，随后从 1 开始依次枚举正整数，并判断其是否在哈希表中
    // 后遍历查询是否出现过该正数，未出现过就返回，全都出现过就返回 max + 1
//    public static int firstMissingPositive(int[] nums) {
//        int n = nums.length;
//        int max = 1;
//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < n; i++) {
//            set.add(nums[i]);
//            if (nums[i] > 0 && nums[i] > max) {
//                max = nums[i];
//            }
//        }
//
//        for (int i = 1; i <= max; i++) {
//            if (!set.contains(i)) {
//                return i;
//            }
//        }
//        return max + 1;
//    }

}
