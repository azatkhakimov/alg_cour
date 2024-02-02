package main.java.com.leetcode._912;

import java.util.Arrays;

public class SortAnArray {
    public int[] sortArray(int[] nums) {
        int[] tempArray = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, tempArray);
        return nums;
    }

    private void mergeSort(int[] arr, int left, int right, int[] tempArray) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid, tempArray);
        mergeSort(arr, mid + 1, right, tempArray);
        merge(arr, left, mid, right, tempArray);
    }

    private void merge(int[] arr, int left, int mid, int right, int[] tempArray) {
        int start1 = left;
        int start2 = mid + 1;
        int n1 = mid - left + 1;
        int n2 = right - mid;
        for (int i = 0; i < n1; i++) {
            tempArray[start1 + i] = arr[start1 + i];
        }
        for (int i = 0; i < n2; i++) {
            tempArray[start2 + i] = arr[start2 + i];
        }

        int i = 0;
        int j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (tempArray[start1 + i] <= tempArray[start2 + j]) {
                arr[k] = tempArray[start1 + i];
                i += 1;
            } else {
                arr[k] = tempArray[start2 + j];
                j += 1;
            }
            k += 1;
        }

        while (i < n1) {
            arr[k] = tempArray[start1 + i];
            i += 1;
            k += 1;
        }
        while (j < n2) {
            arr[k] = tempArray[start2 + j];
            j += 1;
            k += 1;
        }
    }

    public static void main(String[] args) {
        SortAnArray s = new SortAnArray();
        System.out.println(Arrays.toString(s.sortArray(new int[]{5, 2, 3, 1})));//Output: [1,2,3,5]
        System.out.println(Arrays.toString(s.sortArray(new int[]{5, 1, 1, 2, 0, 0})));//Output: [0,0,1,1,2,5]
    }
}
