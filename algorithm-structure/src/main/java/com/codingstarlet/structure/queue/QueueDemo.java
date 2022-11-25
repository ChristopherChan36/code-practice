package com.codingstarlet.structure.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("one");
        queue.offer("two");
        queue.offer("three");
        queue.offer("four");
        // [one, two, three, four]
        System.out.println(queue);
        // one
        System.out.println(queue.poll());
        // [two, three, four]
        System.out.println(queue);
        // two
        System.out.println(queue.peek());
        // [two, three, four]
        System.out.println(queue);
        // two
        // three
        // four
        while (queue.size() > 0) {
            System.out.println(queue.poll());
        }
    }
}
