package com.self.datastructure;

public class PriorityQueue {
    static class Node {
        int value;
        int priority;
        Node next;
    }

    private static Node head = null;

    static int peekMax() {
         if (head != null) return head.value;
         return -1;
    }

    static int extractMax() {
        
    }
}
