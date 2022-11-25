package com.codingstarlet.structure.stack;

import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        // [1, 2, 3, 4]
        System.out.println(stack);
        // 1
        System.out.println(stack.search(4));

        stack.pop();
        stack.pop();
        Integer topElement = stack.peek();
        // 2
        System.out.println(topElement);
        // 2 的位置： 1
        System.out.println("2 的位置： " + stack.search(2));
    }
}
