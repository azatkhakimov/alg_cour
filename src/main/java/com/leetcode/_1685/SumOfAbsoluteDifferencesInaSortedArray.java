package main.java.com.leetcode._1685;

import java.util.Arrays;

public class SumOfAbsoluteDifferencesInaSortedArray {


    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1]+nums[i];
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int leftSum = prefix[i] -nums[i];
            int rightSum = prefix[n-1]-prefix[i];

            int leftCount = i;
            int rightCount = n-1-i;

            int leftTotal = leftCount * nums[i] - leftSum;
            int rightTotal = rightSum - rightCount * nums[i];
            ans[i] = leftTotal + rightTotal;
        }
        return ans;
    }


    public static void main(String[] args) {
        var s = new SumOfAbsoluteDifferencesInaSortedArray();
        System.out.println(Arrays.toString(s.getSumAbsoluteDifferences(new int[]{2,3,5})));//Output: [4,3,5]
        System.out.println(Arrays.toString(s.getSumAbsoluteDifferences(new int[]{1,4,6,8,10})));//Output: Output: [24,15,13,15,21]

    }
}
