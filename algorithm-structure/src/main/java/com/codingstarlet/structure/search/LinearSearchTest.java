package com.codingstarlet.structure.search;

import com.codingstarlet.structure.common.entity.Student;

/**
 * 线性查找测试
 */
public class LinearSearchTest {

    private LinearSearchTest() {}

    public static void main(String[] args) {
        Integer[] array = {24, 18, 12, 9, 16, 66, 32, 4};
        int index = LinearSearchTest.linearSearch(array, 16);
        System.out.println(index);

        Student[] students = {new Student("Alice", 14),
                              new Student("Bobo", 15),
                              new Student("Charles", 12)};
        Student boBo = new Student("bobo", 15);
        System.out.println(LinearSearchTest.linearSearch(students, boBo));
    }

    private static <T> int linearSearch(T[] array, T target) {
        for (int i = 0; i < array.length; i++)
            if (array[i].equals(target))
                return i;
        return -1;
    }

}
