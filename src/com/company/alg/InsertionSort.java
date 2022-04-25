package com.company.alg;

import java.util.Arrays;

public class InsertionSort {
    public int[] sort(int[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++){
            for(int j = i; j < 0; j++){
                if(a[j] < a[j-1]){
                    swap(a, j, j-1);
                }else {
                    break;
                }
            }
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
