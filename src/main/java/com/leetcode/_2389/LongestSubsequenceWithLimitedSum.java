package main.java.com.leetcode._2389;

import java.util.Arrays;

public class LongestSubsequenceWithLimitedSum {

    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];
        }
        int n = queries.length;
        int [] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int index = binarySearch(nums, queries[i]);
            ans[i] = index;
        }
        return ans;
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left<right) {
            int mid = left+(right-left)/2;
            if(nums[mid] == target){
                return mid+1;
            }
            if(nums[mid] < target){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return nums[left] > target ? left : left+1;
    }


    public static void main(String[] args) {
        LongestSubsequenceWithLimitedSum subsequence = new LongestSubsequenceWithLimitedSum();
        System.out.println(Arrays.toString(subsequence.answerQueries(new int[]{4, 5, 2, 1}, new int[]{3, 10, 21})));//Output: [2,3,4]
        System.out.println(Arrays.toString(subsequence.answerQueries(new int[]{2, 3, 4, 5}, new int[]{1})));//Output: [0]
    }
}
