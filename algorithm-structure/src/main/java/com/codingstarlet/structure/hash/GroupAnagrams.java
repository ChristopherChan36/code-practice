package com.codingstarlet.structure.hash;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        //边界条件判断
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<Integer, List<String>> maps = new HashMap<>();
        //每个字母对应一个质数
        int[] prime = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103 };
        for (int i = 0; i < strs.length; i++) {
            char[] ca = strs[i].toCharArray();
            int key = 1;
            for (char c : ca) {
                key *= prime[c - 'a'];
            }
            if (!maps.containsKey(key)) {
                maps.put(key, new ArrayList<>());
            }
            maps.get(key).add(strs[i]);
        }
        return new ArrayList<>(maps.values());
    }

    public List<List<String>> _groupAnagrams_2(String[] strs) {
        //边界条件判断
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> maps = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] ca = strs[i].toCharArray();
            char[] nums = new char[26];
            for (char c : ca) {
                nums[c - 'a']++;
            }
            String keyStr = String.valueOf(nums);
            if (!maps.containsKey(keyStr)) {
                maps.put(keyStr, new ArrayList<>());
            }
            maps.get(keyStr).add(strs[i]);
        }
        return new ArrayList<>(maps.values());
    }

    public List<List<String>> _groupAnagrams_1(String[] strs) {
        Map<String, List<String>> maps = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            // 排序
            char[] ca = strs[i].toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!maps.containsKey(keyStr)) {
                maps.put(keyStr, new ArrayList<>());
            }
            maps.get(keyStr).add(strs[i]);
        }
        return new ArrayList<>(maps.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        System.out.println(groupAnagrams.groupAnagrams(strs));
    }
}
