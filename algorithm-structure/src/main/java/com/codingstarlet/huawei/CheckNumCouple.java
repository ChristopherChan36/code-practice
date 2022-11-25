package com.codingstarlet.huawei;

import java.util.Arrays;
import java.util.Scanner;

public class CheckNumCouple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            // 数组长度
            int length = sc.nextInt();
            int[] arr = new int[length];

            //数组赋值
            for (int i = 0; i < length; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);  // 将数组升序排列
            int i;
            boolean end = false;
            for (i = 0; i < length - 1; i++) {
                for (int j = 0; j < length - 1; j++) {
                    if (j == i)
                        continue;
                    int sum = arr[i] + arr[j] * 2; // 以i=0,j=1为最小和，最小和如果大于数组中的最大值，说明不存在
                    if (sum > arr[length - 1])
                        break;
                    int max = Math.max(i, j);  //比较i/j大小， 取大的值，因为和肯定在下标大的后面才能找到
                    for (int k = max + 1; k < length; k++) {
                        if (sum == arr[k]) {
                            System.out.println(arr[k] + " " + arr[i] + " " + arr[j]);
                            end = true;
                            break;
                        }
                    }
                    if (end) {
                        break;
                    }
                }
                if (end) {
                    break;
                }
            }
            if (i == length - 1) {
                System.out.println(0);
            }
        }
    }
}
