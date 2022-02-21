package com.self.algorithms.sorting;

public class Quicksort {

    public static int[] sampleArray = new int[]{4, 1, 5, 2, 3};

    public static void runSample() {
        QuickSort(sampleArray, 0, sampleArray.length - 1);
        for (int i : sampleArray) {
            System.out.print(i + " ");
        }
    }

    private static void swap(int[] a, int first, int second) {
        int temp = a[first];
        a[first] = a[second];
        a[second] = temp;
    }

    static int partition(int a[], int left, int right)
    {
        int i = left, j = right;
        int pivot = a[left];

        while (i <= j) {
            while (a[i] < pivot) i++;
            while (a[j] > pivot) j--;

            if (i <= j) {
                swap(a, i, j);
                i++;
                j--;
            }
        }

        return i;
    }

    static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int index = partition(arr, left, right);

            quickSort(arr, left, index - 1);
            quickSort(arr, index, right);
        }
    }

    /** ---------------- from CS-5549 Algorithm class ------------ */

    static int Partition(int[] arr, int l, int h) {
        int pivot = arr[l];
        int i = l, j = h;

        while (i < j) {
            do {
                i++;
            } while(arr[i] <= pivot);

            do {
                j--;
            } while (arr[j] > pivot);

            if (i < j) {
                swap(arr, i, j);
            }
        }

        swap(arr, l, j);
        return j;
    }

    static void QuickSort(int[] a, int l, int h) {
        if (l < h) {
            int p = Partition(a, l, h);

            QuickSort(a, l, p);
            QuickSort(a, p + 1, h);
        }
    }
}
