package com.codingstarlet.structure.array;

import java.util.Arrays;

/**
 * LeetCode 189 旋转数组
 * @author chenhaifei
 */
public class RotateArray {

    /**
     * 官方题解： 使用环状替换
     * T(n)=O(n) S(n)=O(1)
     * @param nums 旋转数组
     * @param k 旋转次数
     */
    public void _rotate_3(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        // 记录交换位置的次数, n 个元素交换需要 n 次
        int count = 0;
        for (int start = 0; count < len; start++) {
            // 记录元素交换起始位置指针，从0位置开始换位子
            int cur = start;
            // 记录每次交换下个位置需要替换的元素
            int pre = nums[cur];
            do {
                // 下个交换位置
                int next = (cur + k) % len;
                // 存储下个交换位置元素
                int temp = nums[next];
                // 交换元素
                nums[next] = pre;
                // 赋值下次待交换元素
                pre = temp;
                // 移动交换指针到下个交换起始位置
                cur = next;
                count++;
            } while (cur != start);
        }
    }

    /**
     * 反转数组元素：[1,2,3,4,5,6,7]
     *  1. 第一次反转所有元素 [7,6,5,4,3,2,1]
     *  2. 第二次反转前 k 个元素 [5,6,7,4,3,2,1]
     *  3. 第三次反转 后 n-k 个元素 [5,6,7,1,2,3,4]
     * T(n)=O(n) S(n)=O(1)
     * @param nums 旋转数组
     * @param k 旋转次数
     */
    public void _rotate_2(int[] nums, int k) {
        // 旋转次数取模
        k = k % nums.length;
        reverseArray(nums, 0, nums.length - 1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, nums.length - 1);
    }

    private void reverseArray(int[] nums, int start, int end) {
        int temp;
        while (start < end) {
            temp = nums[end];
            nums[end--] = nums[start];
            nums[start++] = temp;
        }
    }

    /**
     * 暴力求解：按照旋转 k 次依次交换数组元素
     * T(n)=O(n*k)  S(n)=O(1)
     * @param nums 旋转数组
     * @param k 旋转次数
     */
    public void _rotate_1(int[] nums, int k) {
        int temp, lastEle;
        for (int i = 0; i < k; i++) {
            lastEle = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = lastEle;
                lastEle = temp;
            }
        }
    }

    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        // 1. 暴力求解
        // rotateArray._rotate_1(nums, k);
        // 2. 三次数组反转
        // rotateArray._rotate_2(nums, k);
        // 3. 使用环状替换
        rotateArray._rotate_3(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
