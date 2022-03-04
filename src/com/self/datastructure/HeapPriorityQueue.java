package com.self.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeapPriorityQueue {

    public static List<Integer> sampleHeap = new ArrayList(Arrays.asList(8, 6, 5, 2, 3, 4));

    private static void swap(List<Integer> a, int x, int y) {
        if (x < a.size() && y < a.size()) {
            int temp = a.get(x);
            a.set(x, a.get(y));
            a.set(y, temp);
        }
    }

    public static void buildHeap(List<Integer> a) {
        for (int i = (a.size() - 1)/2; i >= 0; i--) {
            heapify(a, a.size(), i);
        }
    }

    private static void heapify(List<Integer> a, int size, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < size && a.get(left) > a.get(largest)) {
            largest = left;
        }

        if (right < size && a.get(right) > a.get(largest)) {
            largest = right;
        }

        if (largest != i) {
            swap(a, largest, i);
            heapify(a, size, largest);
        }
    }

    public static void insert(List<Integer> s, int key) {
        if (s.isEmpty()) {
            s.add(key);
            return;
        }

        s.add(Integer.MIN_VALUE);
        changeKey(s, s.size() - 1, key);
    }

    public static int maximum(List<Integer> s) {
        if (s.isEmpty())
            return -1;
        else
            return s.get(0);
    }

    public static int extractMax(List<Integer> s) {
        if (s.isEmpty()) {
            return -1;
        }

        int length = s.size();
        int max = s.get(0);
        // delete root
        s.set(0, s.get(length - 1));
        s.remove(length - 1);
        length--;
        heapify(s, length, 0);

        return max;
    }

    public static void changeKey(List<Integer> s, int i, int key) {
        if (s.isEmpty() || i >= s.size()) return;


        if (key <= s.get(i)) {
            s.set(i, key);
            heapify(s, s.size(), i);
        } else {
            s.set(i, key);
            int parent = (i - 1) / 2;
            while (i > 0 && s.get(parent) < s.get(i)) {
                swap(s, i, parent);
                i = parent;
                parent = (i - 1) / 2;
            }
        }
    }
}
