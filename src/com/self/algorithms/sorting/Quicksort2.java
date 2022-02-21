package com.self.algorithms.sorting;

public class Quicksort2 {
    public static int[] sampleArray = new int[]{4, 1, 5, 2, 3};

    public static void runSample() {
        quickSort(sampleArray, 0, sampleArray.length - 1);
        for (int i : sampleArray) {
            System.out.print(i + " ");
        }
    }

    private static void quickSort(int a[], int low, int high) {
        if (low < high) {
            int partition = partitionLowPivot(a, low, high);
//            int partition = partitionLowPivot(a, low, high);

            quickSort(a, low, partition - 1);
            quickSort(a, partition + 1, high);
        }
    }

    /**
     * pivot = high position
     */
    private static int partitionHighPivot(int a[], int low, int high) {
        int pivot = a[high];
        int i = low;

        for (int j = low; j < high; j++) {
            if (a[j] <= pivot) {
                // swap
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
            }
        }
        // swap
        int temp = a[i];
        a[i] = a[high];
        a[high] = temp;

        return i;
    }

    /**
     * pivot = low position
     */
    private static int partitionLowPivot(int a[], int low, int high) {
        int pivot = a[low];
        int i = low + 1;

        for (int j = low + 1; j <= high; j++) {
            if (a[j] <= pivot) {
                // swap
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
            }
        }
        // swap
        int temp = a[i - 1];
        a[i - 1] = a[low];
        a[low] = temp;

        return i - 1;
    }

}
