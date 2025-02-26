package com.practice.leetcode.hot_100.slidingWindow;

import java.util.*;

/**
 * @author SSTDL
 * @description
 */
public class findAnagrams_middle {
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
