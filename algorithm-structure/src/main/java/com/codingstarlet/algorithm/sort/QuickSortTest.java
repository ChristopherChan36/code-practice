package com.codingstarlet.algorithm.sort;

import com.codingstarlet.util.Helper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class QuickSortTest implements IMutableSorter {

    @Override
    public void sort(Integer[] A) {
        quickSort_Recur(A, 0, A.length - 1);
    }

    private void quickSort_Recur(Integer[] source, int left, int right) {
        // 出口
        if (left >= right) return;
        // 基准元素，分组
        int pivotIndex = partitionSwap_v1(source, left, right);
        // 小于基准元素
        quickSort_Recur(source, left, pivotIndex - 1);
        quickSort_Recur(source, pivotIndex + 1, right);
    }

    private int partitionSwap_v1(Integer[] source, int left, int right) {
        int pivot = source[left];
        int l = left, r = right;
        while (l < r) {
            while (l < r && source[r] > pivot) r--;
            while (l < r && source[l] <= pivot) l++;
            Helper.swap(source, l, r);
        }
        Helper.swap(source, left, l);
        return l;
    }

    public static void main(String[] args) {

        Integer[] source = {8, 2, 4, 1, 3, 9, 7, 5};
        // quickSortRecur(source, 0, source.length - 1);
        quickSortStack(source, 0, source.length - 1);
        System.out.println(Arrays.deepToString(source));
    }

    /**
     * 快速排序算法：分治法（元素交换：填坑法和指针交换法）
     * 递归实现
     * @param source 原数组
     * @param <E> 元素基础类型
     * @param startIdx 起始位置
     * @param endIdx 结束位置
     */
    private static <E extends Comparable<E>> void quickSortRecur(E[] source, Integer startIdx, Integer endIdx) {
        // 递归结束条件
        if (startIdx >= endIdx) {
            return;
        }
        // 填坑法
        // int pivotIndex = partitionFill(source, startIdx, endIdx);
        // 指针交换法
        int pivotIndex = partitionSwap(source, startIdx, endIdx);
        // 左半区
        quickSortRecur(source, startIdx, pivotIndex - 1);
        quickSortRecur(source, pivotIndex + 1, endIdx);
    }

    private static <E extends Comparable<E>> void quickSortStack(E[] source, Integer startIdx, Integer endIdx) {
        // 用一个集合栈来代替递归的函数栈
        Stack<Map<String, Integer>> quickSortStack = new Stack<>();
        // 首次入栈元素
        Map<String, Integer> rootParam = new HashMap<>();
        rootParam.put("startIdx", startIdx);
        rootParam.put("endIdx", endIdx);
        quickSortStack.push(rootParam);
        // 出栈判断
        while (!quickSortStack.isEmpty()) {
            // 栈顶元素出栈，得到起止下标
            Map<String, Integer> param = quickSortStack.pop();
            // 交换元素
            // 填坑法
            // int pivotIndex = partitionFill(source, startIdx, endIdx);
            // 指针交换法
            int pivotIndex = partitionSwap(source, startIdx, endIdx);
            // 左右半区继续入栈
            if (param.get("startIdx") < pivotIndex - 1) {
                Map<String, Integer> leftParam = new HashMap<>();
                leftParam.put("startIdx", param.get("startIdx"));
                leftParam.put("endIdx", pivotIndex - 1);
                quickSortStack.push(leftParam);
            }
            if (param.get("endIdx") > pivotIndex + 1) {
                Map<String, Integer> rightParam = new HashMap<>();
                rightParam.put("startIdx", pivotIndex + 1);
                rightParam.put("endIdx", param.get("endIdx"));
                quickSortStack.push(rightParam);
            }
        }
    }

    /**
     * 指针交换法
     * @param source
     * @param startIdx
     * @param endIdx
     * @param <E>
     * @return
     */
    private static <E extends Comparable<E>> Integer partitionSwap(E[] source, Integer startIdx, Integer endIdx) {
        /*
         * 右指针与基准元素比较，若大于基准元素，则右指针左移一位；否则停止移动，切换到左指针
         * 左指针小于基准元素，则左指针右移一位；否则停止移动
         * 交换左右指针元素，继续从右指针开始
         */
        // 左右指针
        int left = startIdx, right = endIdx;
        // 基准元素
        E pivot = source[startIdx];
        while (left < right) {
            // 右指针先开始
            while (left < right && source[right].compareTo(pivot) > 0) {
                right--;
            }
            // 由于left一开始指向的是基准元素，判断肯定相等，所以left右移一位
            while (left < right && source[left].compareTo(pivot) <= 0) {
                left++;
            }
            // 交换左右指针元素
            swap(source, left, right);
        }
        // 交换基准元素与左右指针重合位置元素
        swap(source, startIdx, left);
        return left;
    }

    /**
     * 交换元素：填坑法
     * @param source
     * @param startIdx
     * @param endIdx
     * @param <E>
     * @return
     */
    private static <E extends Comparable<E>> Integer partitionFill(E[] source, Integer startIdx, Integer endIdx) {
        /*
        左右指针，以基准元素为中心，分两个半区
            首先，以基准元素位置为坑位
            右指针先移动，若右指针所指元素大于基准元素，则右指针左移一位；否则将右指针指向元素填入坑位，右指针为新的坑位，并且左指针右移一位
            若左指针小于基准元素，则左指针右移一位；否则将左指针所指元素填入坑位，左指针原先位置为新的坑位，并且右指针左移一位
         */
        // 左右指针
        int left = startIdx, right = endIdx;
        // 基准元素
        E pivot = source[startIdx];
        // 坑位
        int fillIdx = startIdx;
        while (left < right) {
            // 右指针半区
            while (left < right) {
                if (source[right].compareTo(pivot) < 0) {
                    source[fillIdx] = source[right];
                    fillIdx = right;
                    left++;
                    break;
                }
                right--;
            }
            // 左指针半区
            while (left < right) {
                if (source[left].compareTo(pivot) > 0) {
                    source[fillIdx] = source[left];
                    fillIdx = left;
                    right--;
                    break;
                }
                left++;
            }
        }
        source[fillIdx] = pivot;
        return fillIdx;
    }

    private static <E> void swap(E[] source, int i, int minIdx) {
        E temp = source[minIdx];
        source[minIdx] = source[i];
        source[i] = temp;
    }
}
