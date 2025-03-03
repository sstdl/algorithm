package com.sstdl.leetcode.hot_100.slidingWindow;

import java.util.HashSet;
import java.util.Set;

/**
 * @author SSTDL
 * @description 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
 *
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class lengthOfLongestSubstring_middle_3 {
    public static void main(String[] args) {
        String test = "qrsvbspk";
        int i = lengthOfLongestSubstring(test);
        System.out.println(i);
    }

    // 滑动窗口解法-AC
    // 从每一个字符开始，不包含重复字符的最长子串
    // 左指针：窗口起始位置，右指针：窗口终止位置
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        int left = 0, right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            // 若字符已经存在 set 中，则移动左指针，直到没有重复字符
            while (set.contains(c)) {
                System.out.println(c + "  " + s.charAt(left));
                set.remove(s.charAt(left));// 移除最左边字符，保证中间没有重复字符
                left ++ ; // 向右移动左指针
            }
            set.add(c);
            max = Math.max(max, right - left + 1);
            right++; // 右指针向右移动
        }
        return max;
    }

    // 暴力解法-TLE
    // 从最大的窗口开始遍历，依次减小窗口的大小
    // 检查有无重复字符，记录最大窗口值返回
//    public static int lengthOfLongestSubstring(String s) {
//        int len = s.length();
//        int max = len;
//        Set<Character> set = new HashSet<>();
//        while (max > 0) {
//            for (int i = 0; i < len; i++) {
//                for (int j = i; j < i + max; j++) {
//                    if (i + max > len) {
//                        break;
//                    }
//                    if (!set.contains(s.charAt(j))) {
//                        set.add(s.charAt(j));
//                        if (set.size() == max) {
//                            return max;
//                        }
//                    } else {
//                        break;
//                    }
//                }
//                set.clear();
//            }
//            max -- ;
//        }
//        return max;
//    }
}
