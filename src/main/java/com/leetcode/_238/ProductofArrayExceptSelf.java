package main.java.com.leetcode._238;

import java.util.Arrays;

public class ProductofArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        left[0] = 1;
        int[] right = new int[n];
        right[nums.length-1] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = nums[i-1]*left[i-1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = nums[i+1]*right[i+1];
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = left[i]*right[i];
        }
        return result;
    }


    public static void main(String[] args) {
        var p = new ProductofArrayExceptSelf();
        System.out.println(Arrays.toString(p.productExceptSelf(new int[]{1,2,3,4})));//Output: [24,12,8,6]
        System.out.println(Arrays.toString(p.productExceptSelf(new int[]{-1,1,0,-3,3})));//Output: [0,0,9,0,0]
    }
}
