package com.codingstarlet.huawei;

import java.util.Scanner;

public class NBinarySub {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().split(" ");
        System.out.println(sub(Integer.parseInt(str[0]), str[1], str[2]));
    }

    private static String sub(Integer N, String a, String b) {
        StringBuilder res = new StringBuilder();
        int borrow = 0;
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0) {

            int x = i >= 0 ? getInt(a.charAt(i)) : 0;
            int y = j >= 0 ? getInt(b.charAt(j)) : 0;
            int z = (x - borrow - y + N) % N;
            res.append(getChar(z));
            borrow = x - borrow - y < 0 ? 1 : 0;
            i--;
            j--;
        }
        res.reverse();
        //删除前导0。注意：循环条件是res.size()-1是为防止"0000"的情况
        int pos;
        for (pos = 0; pos < res.toString().length() - 1; pos++) {
            if (res.toString().charAt(pos) != '0') break;
        }
        return res.substring(pos);
    }
    private static char getChar(int n) {
        if (n <= 9) {
            return (char) (n + '0');
        } else {
            return (char) (n - 10 + 'a');
        }
    }
    private static int getInt(char ch) {
        if ('0' <= ch && ch <= '9') return ch - '0';
        else return ch - 'a' + 10;
    }
}
