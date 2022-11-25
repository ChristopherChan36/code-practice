package com.codingstarlet.structure.queue;

import java.util.Deque;
import java.util.LinkedList;

public class DequeDemo {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addLast("c");
        // [b, a, c]
        System.out.println(deque);
        // b
        System.out.println(deque.peek());
        // [b, a, c]
        System.out.println(deque);
        while (deque.size() > 0) {
            System.out.println(deque.pollFirst());
        }
    }
}
