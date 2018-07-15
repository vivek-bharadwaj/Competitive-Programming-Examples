package com.java.codechef.contests;

import java.util.Scanner;

/**
 * Given the list of numbers, you are to sort them in non decreasing order.
 * Input
 * t – the number of numbers in list, then t lines follow [t <= 10^6].
 * Each line contains one integer: N [0 <= N <= 10^6]
 * <p>
 * Output
 * Output given numbers in non decreasing order.
 * Example
 * Input:
 * <p>
 * 5
 * 5
 * 3
 * 6
 * 7
 * 1
 * Output:
 * <p>
 * 1
 * 3
 * 5
 * 6
 * 7
 */


class TSort {
    private static void mergeSort(int[] a, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(a, l, m);
            mergeSort(a, m + 1, r);
            merge(a, l, m, r);
        }
    }

    private static void merge(int[] a, int l, int m, int r) {
        int n1, n2;

        // Number of elements in left sub-array and right sub-array
        n1 = m - l + 1;
        n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = a[l + i];
        }

        for (int j = 0; j < n2; j++) {
            R[j] = a[m + 1 + j];
        }

        int i = 0, j = 0;

        int k = l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                a[k] = L[i];
                i++;
            } else {
                a[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            a[k++] = L[i++];
        }

        while (j < n2) {
            a[k++] = R[j++];
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        mergeSort(arr, 0, n - 1);

        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }


}
