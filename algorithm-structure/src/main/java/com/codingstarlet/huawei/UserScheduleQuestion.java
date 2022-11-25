package com.codingstarlet.huawei;

import java.util.Arrays;
import java.util.Scanner;

public class UserScheduleQuestion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int userNum = sc.nextInt();
            int[][] res = new int[userNum][3];
            for(int i=0;i<userNum;i++) {
                for(int j=0;j<3;j++) {
                    res[i][j] = sc.nextInt();
                }
            }
            jobDispatch(res,userNum);
        }
        sc.close();
    }
    public static void jobDispatch(int[][] res,int userNum) {
        // 使用二维数组保存状态：每个维度的含义分别是：[当前用户ID][所选的任务策略：A为0、B为1,、C为2],默认从下标1开始,所以是4
        int[][] dp = new int[userNum+1][4];
        for(int[] temp : dp) {
            Arrays.fill(temp,Integer.MAX_VALUE);
        }
        // result用来存放不同用户数量时的最小结果:比如result[0]就是只有一个用户时的最小消耗
        int[] result = new int[userNum];
        Arrays.fill(result,Integer.MAX_VALUE);
        // 边界值,初始化第一个用户选择各种策略的总消耗
        for(int index=1;index <= 3;index++) {
            dp[1][index] = res[0][index-1];
            result[0] = Math.min(result[0],dp[1][index]);
        }
        dp[0][0] = 0;

        // 因为前面用户选了某个策略，后面的用户就只能选不同的；所以对应了后面用户其实有三种选择情况
        // 所有用户都可以在前面的用户选择后递推出自己的最优消耗
        for(int i=2;i<=userNum;i++) {
            dp[i][1] = Math.min(dp[i-1][2],dp[i-1][3]) + res[i-1][0];
            dp[i][2] = Math.min(dp[i-1][1],dp[i-1][3]) + res[i-1][1];
            dp[i][3] = Math.min(dp[i-1][1],dp[i-1][2]) + res[i-1][2];
            result[i-1] = Math.min(result[i-1],Math.min(Math.min(dp[i][1],dp[i][2]),dp[i][3]));
        }
        System.out.println(result[userNum-1]);
    }
}
