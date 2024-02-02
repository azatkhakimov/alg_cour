package main.java.com.leetcode._1539;

public class KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (arr[middle] - 1 - middle < k) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return left + k;
    }


    public static void main(String[] args) {
        KthMissingPositiveNumber k = new KthMissingPositiveNumber();
        System.out.println(k.findKthPositive(new int[]{2, 3, 4, 7, 11}, 5));//Output: 9
        System.out.println(k.findKthPositive(new int[]{1, 2, 3, 4}, 2));//Output: 6
    }
}
