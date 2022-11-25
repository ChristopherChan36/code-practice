package com.codingstarlet.algorithm.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MergeSortTest implements IMutableSorter {

    @Override
    public void sort(Integer[] A) {
        // 分治 区间：左闭右开
        mergeSort_Recur(A, 0, A.length);
    }

    private void mergeSort_Recur(Integer[] source, int start, int end) {
        // 终止条件 左闭右开
        if (end - start <= 1) {
            return;
        }
        // 分组
        int mid = start + (end - start) / 2;
        mergeSort_Recur(source, start, mid);
        mergeSort_Recur(source, mid, end);
        // 归并
        combineSort(source, start, mid, end);
    }

    private void combineSort(Integer[] source, int start, int mid, int end) {
        int p1 = start, p2 = mid, p = 0;
        Integer[] tempArray = new Integer[end - start];
        while (p1 < mid && p2 < end) {
            if (source[p1] < source[p2]) {
                tempArray[p++] = source[p1++];
            } else {
                tempArray[p++] = source[p2++];
            }
        }
        while (p1 < mid) tempArray[p++] = source[p1++];
        while (p2 < end) tempArray[p++] = source[p2++];
        // 将临时大数组赋值到原数组中
        for (int i = 0; i < tempArray.length; i++) {
            source[start + i] = tempArray[i];
        }
    }

    public static void main(String[] args) {
        Integer[] source = {8, 2, 4, 1, 3, 9, 7, 5};
        mergeSortRecur(source, 0, source.length - 1);
        System.out.println(Arrays.deepToString(source));
        String s = "abcdxabcde", t = "eidbabcdeabcdxaooo";
        System.out.println(checkInclusion(s, t));
    }

    private static void mergeSortRecur(Integer[] source, int startIdx, int endIdx) {
        // 分组结束条件
        if (startIdx < endIdx) {
            // 分组：折半成两个小集合，分别进行递归(前序位置)
            int mid = (startIdx + endIdx) / 2;
            mergeSortRecur(source, startIdx, mid);
            mergeSortRecur(source, mid + 1, endIdx);
            // 归并: 将两个小集合归并成一个大的有序集合(后序位置)
            mergeSort(source, startIdx, mid, endIdx);
        }
    }

    private static void mergeSort(Integer[] source, int startIdx, int mid, int endIdx) {
        // 第一步：首先创建一个大的临时集合，用于容纳两个小集合元素
        Integer[] tempArray = new Integer[endIdx - startIdx + 1];
        // 三个指针
        int p1 = startIdx, p2 = mid + 1, p = 0;
        while (p1 <= mid && p2 <= endIdx) {
            if (source[p1].compareTo(source[p2]) < 0) {
                tempArray[p++] = source[p1++];
            } else {
                tempArray[p++] = source[p2++];
            }
        }
        // p1 未走到左集合终点
        while (p1 <= mid) {
            // 将集合剩余元素按原顺序赋值到大集合中
            tempArray[p++] = source[p1++];
        }
        while (p2 <= endIdx) tempArray[p++] = source[p2++];
        // 将临时大数组赋值到原数组中
        for (int i = 0; i < tempArray.length; i++) {
            source[startIdx + i] = tempArray[i];
        }
    }

    public static boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0, valid = 0;
        while (right < s2.length()) {
            char r = s2.charAt(right);
            right++;
            if (need.containsKey(r)) {
                window.put(r, window.getOrDefault(r, 0) + 1);
                if (need.get(r).equals(window.get(r))) {
                    valid++;
                }
            }
            while (right - left >= s1.length()) {
                if (valid == need.size()) {
                    return true;
                }
                char l = s2.charAt(left);
                left++;
                if (need.containsKey(l)) {
                    if (need.get(l).equals(window.get(l))) {
                        valid--;
                    }
                    window.put(l, window.get(l) - 1);
                }
            }
        }
        return false;
    }
}
