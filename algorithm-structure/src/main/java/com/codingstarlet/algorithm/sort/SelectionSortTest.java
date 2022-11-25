package com.codingstarlet.algorithm.sort;

import ch.qos.logback.core.joran.conditional.IfAction;
import com.codingstarlet.util.Helper;

import java.util.Arrays;

/**
 * 选择排序
 * @author chenhaifei
 */
public class SelectionSortTest implements IMutableSorter {

    @Override
    public void sort(Integer[] A) {
        for (int i = 0; i < A.length; i++) {
            int minIdx = i;
            for (int j = i; j < A.length; j++) {
                if (A[j] < A[minIdx]) {
                    minIdx = j;
                }
            }
            Helper.swap(A, minIdx, i);
        }
    }

    public static void main(String[] args) {

        Integer[] source = {8, 2, 4, 1, 3, 9, 7, 5};

        selectionSort(source);
        System.out.println(Arrays.deepToString(source));
    }

    private static <E extends Comparable<E>> void selectionSort(E[] source) {

    }

    private static <E extends Comparable<E>> void selectionSortReverse(E[] source) {
        for (int i = source.length - 1; i >= 0; i--) {
            int maxIdx = i;
            for (int j = i; j >= 0; j--) {
                if (source[j].compareTo(source[maxIdx]) > 0) {
                    maxIdx = j;
                }
            }
            swap(source, i , maxIdx);
        }
    }

    private static <E> void swap(E[] source, int i, int minIdx) {
        E temp = source[minIdx];
        source[minIdx] = source[i];
        source[i] = temp;
    }


}
