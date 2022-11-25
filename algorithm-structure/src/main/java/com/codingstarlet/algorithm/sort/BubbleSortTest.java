package com.codingstarlet.algorithm.sort;

import java.util.Arrays;

public class BubbleSortTest implements IMutableSorter {

    @Override
    public void sort(Integer[] A) {
        bubbleSortV3(A);
    }

    private static void bubbleSortV3(Integer[] source) {
        // 元素最后一次交换的位置
        int lastSwapIdx = 0;
        // 数组无序元素边界位置
        int sortedIdx = source.length - 1;
        for (int i = 0; i < source.length; i++) {
            // 数组是否有序
            boolean isSorted = true;
            for (int j = 0; j < sortedIdx; j++) {
                if (source[j] > source[j + 1]) {
                    swap(source, j, j + 1);
                    isSorted = false;
                    lastSwapIdx = j;
                }
            }
            sortedIdx = lastSwapIdx;
            if (isSorted) {
                return;
            }
        }
    }

    private static void bubbleSortV2(Integer[] source) {
        for (int i = 0; i < source.length; i++) {
            // 数组是否有序
            boolean isSorted = true;
            for (int j = 0; j < source.length - i - 1; j++) {
                if (source[j] > source[j + 1]) {
                    swap(source, j, j + 1);
                    isSorted = false;
                }
            }
            if (isSorted) return;
        }
    }

    private static void bubbleSortV1(Integer[] source) {
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source.length - i - 1; j++) {
                if (source[j] > source[j + 1]) {
                    swap(source, j, j + 1);
                }
            }
        }
    }

    private static <E> void swap(E[] source, int i, int minIdx) {
        E temp = source[minIdx];
        source[minIdx] = source[i];
        source[i] = temp;
    }

    public static void main(String[] args) {
        Integer[] source = {8, 2, 4, 1, 3, 9, 7, 5, 13, 6};
        // bubbleSortV1(source);
        // bubbleSortV2(source);
        bubbleSortV3(source);
        System.out.println(Arrays.deepToString(source));
    }
}
