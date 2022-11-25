package com.codingstarlet.structure.array;

public class DuplicatesFromSortedArrayRemove {
    public static int removeDuplicates(int[] nums) {
        // 定义双指针，p 记录不重复元素，q 指向不重复元素
        int p = 0, q = 0;
        while (q < nums.length) {
            // q 指向不重复元素
            while (q < nums.length && nums[p] == nums[q]) {
                q++;
            }
            // 将 q 指向的不重复元素与 (p+1) 交换位置
            if (q < nums.length) {
                nums[++p] = nums[q++];
            }
        }
        return p + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        int len = removeDuplicates(nums);
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }
}
