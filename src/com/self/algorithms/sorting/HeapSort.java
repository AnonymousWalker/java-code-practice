package com.self.algorithms.sorting;

public class HeapSort {
    private static int[] sampleArray = new int[]{4, 1, 5, 2, 8};

    public static void runSample() {
        heapSort(sampleArray);
        for (int i : sampleArray) {
            System.out.print(i + " ");
        }
    }

    private static void swap(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    public static void heapify(int[] a, int size, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < size && a[left] > a[largest]) {
            largest = left;
        }

        if (right < size && a[right] > a[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(a, largest, i);
            heapify(a, size, largest);
        }
    }

    public static void heapSort(int[] a) {
        // build heap
        for (int i = (a.length - 1) / 2; i >= 0; i--) {
            heapify(a, a.length, i);
        }
        // remove nodes and heapify()
        for (int i = a.length - 1; i >= 0; i--) {
            swap(a, 0, i);
            heapify(a, i, 0);
        }
    }
}
