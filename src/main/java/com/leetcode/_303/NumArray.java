package main.java.com.leetcode._303;

import java.util.Arrays;

public class NumArray {
    int[] sums;
    public NumArray(int[] nums) {
        sums = new int[nums.length];
        int currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            sums[i] = currSum;
        }
        System.out.println(Arrays.toString(sums));
    }


    public int sumRange(int left, int right) {
        if(left == 0){
            return sums[right];
        }else {
            return sums[right] - sums[left-1];
        }
    }
}
