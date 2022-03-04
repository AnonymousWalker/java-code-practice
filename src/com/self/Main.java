package com.self;

import com.self.datastructure.HeapPriorityQueue;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        var list = Arrays.asList(3,1,5,4,2);
        System.out.println("--- Build Heap Example ---");
        System.out.print("Before - ");
        printList(list);
        HeapPriorityQueue.buildHeap(list);
        System.out.print("After - ");
        printList(list);

        System.out.println("--- Priority Queue Example ---");
        var heap = HeapPriorityQueue.sampleHeap;
        printList(heap);
        System.out.println("Max = " + HeapPriorityQueue.maximum(heap));
        System.out.print("Now, Extract Max = " + HeapPriorityQueue.extractMax(heap) + " \n-> ");
        printList(heap);
        System.out.print("Now, Insert 9 \n-> "); HeapPriorityQueue.insert(heap, 9);
        printList(heap);
        System.out.print("Now, Change 2 to 10 \n-> "); HeapPriorityQueue.changeKey(heap, 3, 10);
        printList(heap);
    }

    static void printList(List<Integer> list) {
        System.out.print("Heap: ");
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
