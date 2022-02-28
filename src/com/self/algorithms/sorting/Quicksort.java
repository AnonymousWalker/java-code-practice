package com.self.algorithms.sorting;

public class Quicksort {

//    public static int[] sampleArray = new int[]{4, 1, 5, 2, 3};
//    public static int[] sampleArray = new int[]{1,2,3,4,5};
    public static int[] sampleArray = new int[]{5, 4, 3, 2, 1};

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

    static int partition(int a[], int left, int right) {
        int pivot = a[left];
        int i = left, j = right;

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

    /**
     * ---------------- from CS-5549 Algorithm class ------------
     */

    static int Partition(int arr[], int l, int h) {
        int pivot = arr[l];
        int i = l, j = h;
        while (i < j) {
            System.out.println("i + +");
            while (i <= h && arr[i] <= pivot) {
                System.out.println("arr[" + i + "] = "+ arr[i]);
                i++;
            }
            System.out.println("j + +");
            while (j >=0 && arr[j] > pivot) {
                System.out.println("arr[" + j + "] = "+ arr[i]);
                j--;
            }

            if (i < j) {
                swap(arr, i, j);
            }
        }

        swap(arr, l, j);
        return j;
    }

    static void QuickSort(int arr[], int l, int h) {
        if (l >= h)
            return;

        int j = Partition(arr, l, h);

        // Sorting the left part
        QuickSort(arr, l, j - 1);

        // Sorting the right part
        QuickSort(arr, j + 1, h);
    }
}
