package com.self.algorithms.sorting;

public class MergeSort {
    public static int[] sampleArray = new int[]{4, 1, 5, 2, 8};

    public static void runSample() {
        int[] a = sampleArray.clone();
        System.out.println("Before:");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

        sort(a, 0, a.length - 1);

        System.out.println("\nAfter:");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void sort(int[] a, int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;
            sort(a, l, mid);
            sort(a, mid + 1, r);
            merge(a, l, mid, r);
        }
    }

    private static void merge(int[] a, int l, int mid, int r) {
        int lSize = mid - l + 1;
        int rSize = r - mid;
        int[] leftList = new int[lSize];
        int[] rightList = new int[rSize];
        int i, j;

        for (i = 0; i < lSize; i++) {
            leftList[i] = a[l + i];
        }
        for (j = 0; j < rSize; j++) {
            rightList[j] = a[mid + 1 + j];
        }

        int k = l;
        i = j = 0;

        while (i < lSize && j < rSize) {
            if (leftList[i] <= rightList[j]) {
                a[k++] = leftList[i++];
            } else {
                a[k++] = rightList[j++];
            }
        }

        // copy remaining elements
        while (i < lSize) a[k++] = leftList[i++];
        while (j < rSize) a[k++] = rightList[j++];
    }
}
