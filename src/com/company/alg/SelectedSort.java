package com.company.alg;

import java.util.Arrays;

public class SelectedSort {
    public int[] sort(int[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            swap(a, i, min);
        }
        return a;
    }

    private void swap(int[] a, int i, int min) {
        int temp = a[i];
        a[i] = a[min];
        a[min] = temp;
    }

    public static void main(String[] args) {
        SelectedSort selectedSort = new SelectedSort();
        int[] a = new int[]{5,1,0,12,2,6,8};
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(selectedSort.sort(a)));
    }
}
