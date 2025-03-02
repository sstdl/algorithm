package com.practice.leetcode.hot_100.subString;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SSTDL
 * @description
 */
public class minWindow_hard {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABCB";
        String res = minWindow(s, t);
        System.out.println(res);
    }

    public static String minWindow(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        if (slen < tlen) return "";

        Map<Character, Integer> tMap = new HashMap<>();
        // 统计字符串 t 中各个字符的出现次数
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int count = 0;
        Map<Character, Integer> sMap = new HashMap<>();

        while (right < slen) {
            char rChar = s.charAt(right);
            sMap.put(rChar, sMap.getOrDefault(rChar, 0) + 1);

            // 只有当窗口内该字符数量刚好等于 tMap 需求的数量时，count 才增加
            if (tMap.containsKey(rChar) && sMap.get(rChar).equals(tMap.get(rChar))) {
                count++;
            }
            // 统计 count 是否等于 tMap.size() 而不是 tlen，只要所有字符都出现过且满足次数要求，就可以
            while (count == tMap.size()) {  // 满足条件，尝试收缩窗口
                int windowLen = right - left + 1;
                if (windowLen < minLen) {
                    minLen = windowLen;
                    start = left;
                }
                char lChar = s.charAt(left);
                sMap.put(lChar, sMap.get(lChar) - 1);
                // 只有当移除的字符影响 count 时，count 才减少
                if (tMap.containsKey(lChar) && sMap.get(lChar) < tMap.get(lChar)) {
                    count--;
                }
                left++;
            }
            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
