package com.sstdl.leetcode.hot_100.slidingWindow;

import java.util.*;

/**
 * @author SSTDL
 * @description 438. 找到字符串中所有字母异位词
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * 示例 1:
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *
 *  示例 2:
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 */
public class findAnagrams_middle_438 {
    public static void main(String[] args) {
        String s = "cbaebabacd", p = "ab";
        List<Integer> anagrams = findAnagrams(s, p);
        System.out.println(anagrams);
    }


    // 滑动窗口-AC
    // 固定窗口值，对每个窗口中的字符串，转换为字符数组排序，和原数组比较
    // 相同就添加索引，不断后移窗口的位置进行更新
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int slen = s.length();
        int plen = p.length();
        char[] pCharArray = p.toCharArray();
        Arrays.sort(pCharArray);
        int left = 0;
        int right = left + plen;
        while (right <= slen) {
            String substring = s.substring(left, right);
            char[] subCharArray = substring.toCharArray();
            Arrays.sort(subCharArray);
            System.out.println(Arrays.toString(pCharArray) + " " + Arrays.toString(subCharArray));
            if (Arrays.equals(subCharArray, pCharArray)) {
                list.add(left);
            }
            right++;
            left++;
        }
        return list;
    }
}
