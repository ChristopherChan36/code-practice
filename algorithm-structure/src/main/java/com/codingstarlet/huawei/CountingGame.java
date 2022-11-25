package com.codingstarlet.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 100个人围成一圈，每个人有一个编码，编号从1开始到100.他们从1开始依次报数，报到为M的人自动退出圈圈，然后下一个人接着从1开始报数，
 * 直到剩余的人数小于M。请问最后剩余的人在原先的编号为多少？
 *
 * 例如输入M=3时，输出为：“58，91”，
 * 输入M=4时，输出为： “34，45， 97”。
 * 如果m小于等于1， 则输出“ERROR!”;
 * 如果m大于等于100，则输出“ERROR!”；
 */
public class CountingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = Integer.parseInt(scanner.nextLine());
        if (m <= 1 || m >= 100) {
            System.out.println("ERROR!");
        }
        // 记录是否被淘汰，false 未淘汰 true 淘汰
        boolean[] eliminate = new boolean[101];
        // 记录当前未被淘汰人数
        int size = 100;
        // 当前报数者索引
        int curNum = 1;
        while (size >= m) {
            // 找到应该置 true 的下标位置
            for (int i = 1; i < m; i++) {
                curNum++;
                // 如果 curNum 下标当前元素值为false，则 curNum 不变，否则，指向下一个为 false 的索引
                curNum = getValidIndex(eliminate, curNum);
            }
            eliminate[curNum] = true;
            curNum = getValidIndex(eliminate, curNum);
            size--;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < eliminate.length; i++) {
            if (!eliminate[i]) {
                res.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.size(); i++) {
            sb.append(res.get(i));
            if (i != res.size() - 1) {
                sb.append(", ");
            }
        }
        System.out.println(sb);
    }

    private static int getValidIndex(boolean[] eliminate, int curNum) {
        if (curNum == 101) {
            curNum = 1;
        }
        while (eliminate[curNum]) {
            curNum++;
            if (curNum == 101) {
                curNum = 1;
            }
        }
        return curNum;
    }
}
