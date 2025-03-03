package com.sstdl.leetcode.hot_100.subString;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SSTDL
 * @description 76. 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 注意：
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 示例 1：
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 *
 * 示例 2：
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 解释：整个字符串 s 是最小覆盖子串。
 *
 * 示例 3:
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串
 */
public class minWindow_hard_76 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABCB";
        String res = minWindow(s, t);
        System.out.println(res);
    }

    // 滑动窗口-AC
    // 时间复杂度O(N)，左右指针各遍历一次
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
