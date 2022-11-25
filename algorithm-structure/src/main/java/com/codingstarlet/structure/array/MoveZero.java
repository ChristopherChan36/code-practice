package com.codingstarlet.structure.array;

import java.util.Arrays;

public class MoveZero {
    public static void moveZeroes(int[] nums) {
        // nums 数组为空直接返回
        if (nums == null || nums.length == 0) {
            return;
        }
        // 一次遍历：利用的快排思想，以0为中间元素，将非0 的全部按顺序放入左边，0放在右边
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                if(i > j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
        char a = 'A';
        System.out.println(a + 32);
    }


}
