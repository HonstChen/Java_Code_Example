package com.itheima.test;

import java.util.Random;

public class SkipList {
    private static final int MAX_LEVEL = 16; // 最大层数
    private int levelCount = 1; // 当前跳表的层数
    private Node head = new Node(MAX_LEVEL); // 跳表的头节点

    // 跳表节点类
    private class Node {
        private int value;
        private Node[] next;

        public Node(int level) {
            next = new Node[level];
        }
    }

    // 插入节点
    public void insert(int value) {
        int level = randomLevel(); // 随机生成节点的层数
        Node newNode = new Node(level);
        newNode.value = value;

        Node[] update = new Node[level]; // 用于保存每层的插入位置
        for (int i = 0; i < level; i++) {
            update[i] = head;
        }

        Node p = head;
        for (int i = level - 1; i >= 0; i--) {
            while (p.next[i] != null && p.next[i].value < value) {
                p = p.next[i];
            }
            update[i] = p;
        }

        for (int i = 0; i < level; i++) {
            newNode.next[i] = update[i].next[i];
            update[i].next[i] = newNode;
        }

        if (levelCount < level) {
            levelCount = level;
        }
    }

    // 删除节点
    public void delete(int value) {
        Node[] update = new Node[levelCount];
        Node p = head;
        for (int i = levelCount - 1; i >= 0; i--) {
            while (p.next[i] != null && p.next[i].value < value) {
                p = p.next[i];
            }
            update[i] = p;
        }

        if (p.next[0] != null && p.next[0].value == value) {
            for (int i = levelCount - 1; i >= 0; i--) {
                if (update[i].next[i] != null && update[i].next[i].value == value) {
                    update[i].next[i] = update[i].next[i].next[i];
                }
            }
        }
    }

    // 查找节点
    public boolean search(int value) {
        Node p = head;
        for (int i = levelCount - 1; i >= 0; i--) {
            while (p.next[i] != null && p.next[i].value < value) {
                p = p.next[i];
            }
        }

        if (p.next[0] != null && p.next[0].value == value) {
            return true;
        }

        return false;
    }

    // 随机生成节点的层数
    private int randomLevel() {
        Random random = new Random();
        int level = 1;
        while (random.nextInt(2) == 1 && level < MAX_LEVEL) {
            level++;
        }
        return level;
    }

    // 打印跳表
    public void print() {
        Node p = head;
        while (p.next[0] != null) {
            System.out.print(p.next[0].value + " ");
            p = p.next[0];
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SkipList skipList = new SkipList();
        skipList.insert(1);
        skipList.insert(3);
        skipList.insert(2);
        skipList.insert(5);
        skipList.insert(4);
        skipList.print();

        skipList.delete(3);
        skipList.delete(5);
        skipList.print();

        System.out.println(skipList.search(2)); // 输出: true
        System.out.println(skipList.search(5)); // 输出: false
    }
}