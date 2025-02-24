package com.practice.leetcode.hashTable;

import java.util.*;

/**
 * @author SSTDL
 * @description
 */
public class groupAnagrams_middle {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strs);
        System.out.println(lists);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = String.valueOf(charArray);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                ArrayList<String> list = new ArrayList<>(Arrays.asList(str));
                map.put(key, list);
            }
        }
        List<List<String>> lists = new ArrayList<>(map.values());
        return lists;
    }
}
