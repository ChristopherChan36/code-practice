package com.codingstarlet.structure.common.generator;

import java.util.Random;

public class ArrayGenerator {

    public ArrayGenerator() {
    }

    public static Integer[] generateRandomArray(int n, int bound) {
        Integer[] array = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(bound);
        }
        return array;
    }
}
