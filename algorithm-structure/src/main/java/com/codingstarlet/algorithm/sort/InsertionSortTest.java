package com.codingstarlet.algorithm.sort;

import java.util.Arrays;

public class InsertionSortTest implements IMutableSorter {

    @Override
    public void sort(Integer[] A) {
        for (int i = 1; i < A.length; i++) {
            int insert = A[i];
            int j = i;
            for (; j > 0 && A[j - 1] > insert; j--) {
                A[j] = A[j - 1];
            }
            A[j] = insert;
        }
    }

    public static void main(String[] args) {

        Integer[] source = {8, 2, 4, 1, 3, 9, 7, 5};

        // insertionSort(source);
        insertSortTest(source);
        System.out.println(Arrays.deepToString(source));

        // Student student = new Student();
        // student.setAge(11);
        // int age = Objects.nonNull(student.getAge()) ? student.getAge() : 0;
        // System.out.println(age);

    }

    /**
     * 插入排序
     * @param source 原数组
     */
    private static void insertSortTest(Integer[] source) {
        // 从第二个元素开始记步
        for (int i = 1; i < source.length; i++) {
            Integer insertValue = source[i];
            int j = i;
            for (; j > 0 && insertValue < source[j - 1] ; j--) {
                // source[j - 1] 后移一位
                source[j] = source[j - 1];
            }
            source[j] = insertValue;
        }
    }

    private static <E extends Comparable<E>> void insertionSort(E[] source) {

    }

    private static <E> void insert(E[] source, int sourceIdx, int targetIdx) {
        E temp = source[sourceIdx];
        System.arraycopy(source, targetIdx, source, targetIdx + 1, (sourceIdx - targetIdx));
        source[targetIdx] = temp;
    }
}
