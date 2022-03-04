package com.self.datastructure;

public class PriorityQueueLinkedList {
    static class Node {
        int value;
        int priority;
        Node next = null;

        Node(int v, int p) {
            value = v;
            priority = p;
        }
    }

    private static Node head = null;

    static int peek() {
         if (head != null) return head.value;
         return -1;
    }

    static int extractMax() {
        int value = peek();
        if (value != -1) {
            // delete head
            head = head.next;
        }
        return value;
    }

    static void push(int value, int priority) {
        Node newNode = new Node(value, priority);
        if (head == null) {
            head = new Node(value, priority);
            return;
        }

        Node temp = head;
        Node previousTemp = null;

        while (temp != null && temp.priority > priority) {
            previousTemp = temp;
            temp = temp.next;
        }

        if (temp == null) {
            previousTemp.next = newNode;
        } else {
            if (previousTemp == null) {
                newNode.next = head;
                head = newNode;
            } else {
                newNode.next = temp;
                previousTemp.next = newNode;
            }
        }
    }

    public static void runSample() {
        head = new Node(1,1);
        push(3,3);
        push(2,2);
        push(4,4);

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
    }
}
