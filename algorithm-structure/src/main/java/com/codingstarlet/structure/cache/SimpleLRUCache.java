package com.codingstarlet.structure.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用双向链表+哈希表结构实现 LRU 淘汰算法结构
 * @author chenhaifei
 */
public class SimpleLRUCache {
    // 双向链表
    private DoubleListNode doubleListNode;
    // 哈希表
    private Map<Integer, Node> hashMap;
    private Integer capacity;
    public SimpleLRUCache(Integer capacity) {
        this.capacity = capacity;
        doubleListNode = new DoubleListNode();
        hashMap = new HashMap<>();
    }

    /**
     * 新增节点
     * @param key
     * @return
     */
    public Integer get(Integer key) {
        if (!hashMap.containsKey(key)) {
            return -1;
        }
        // key 提升优先级
        makeRecently(key);
        return hashMap.get(key).val;
    }

    public void put(Integer key, Integer val) {
        // 若key 已存在，更新 val 值
        if (hashMap.containsKey(key)) {
            // 删除数据
            deleteKey(key);
            // 添加最近使用的节点
            addRecently(key, val);
            return;
        }
        // 判断容量是否已满
        if (doubleListNode.length() == capacity) {
            // 移除最久未使用元素
            removeLeastRecently();
        }
        // 新增节点
        addRecently(key, val);
    }

    private void removeLeastRecently() {
        Node node = doubleListNode.removeFirst();
        hashMap.remove(node.key);
    }

    private void addRecently(Integer key, Integer val) {
        Node addNode = new Node(key, val);
        doubleListNode.addNodeLast(addNode);
        hashMap.put(key, addNode);
    }

    private void deleteKey(Integer key) {
        // 删除链表节点
        Node node = hashMap.get(key);
        doubleListNode.remove(node);
        hashMap.remove(key);
    }

    private void makeRecently(Integer key) {
        // 删除链表原先节点
        Node node = hashMap.get(key);
        doubleListNode.remove(node);
        // 新增节点
        doubleListNode.addNodeLast(node);
    }


    // 双向链表单节点元素，存储 key, val
    static class Node {
        public int key, val;
        // 前驱、后缀指针
        public Node pre, next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    // 双向链表
    static class DoubleListNode {
        private int length;
        // 链表首位虚节点
        private Node head, tail;
        public DoubleListNode() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.pre = head;
            length = 0;
        }

        // 链表尾部新增节点
        public void addNodeLast(Node node) {
            node.pre = tail.pre;
            node.next = tail;
            tail.pre.next = node;
            tail.pre = node;
            length++;
        }

        // 移除链表指定节点（节点一定存在）| 由于是双链表且给的是目标 Node 节点，时间 O(1)
        public void remove(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            length--;
        }

        // 移除链表第一个节点并返回该节点
        public Node removeFirst() {
            Node removeNode = head.next;
            if (removeNode == null) return null;
            remove(removeNode);
            return removeNode;
        }

        // 返回链表长度 O(1)
        public Integer length() {
            return length;
        }
    }
}
