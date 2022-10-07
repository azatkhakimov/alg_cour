package leetcode._673;

import java.util.Arrays;

public class NumberOfLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int [] dpL = new int[n];
        Arrays.fill(dpL, 1);

        int[] dpC = new int[n];
        Arrays.fill(dpC, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i] <= nums[j]){
                    continue;
                }
                if(dpL[j] + 1 > dpL[i]){
                    dpL[i] = dpL[j] + 1;
                    dpC[i] = dpC[j];
                }else if(dpL[j] + 1 == dpL[i]){
                    dpC[i] += dpC[j];
                }
            }
        }
        int maxLength = 0;
        for (int i : dpL) {
            maxLength = Math.max(maxLength, i);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(dpL[i] == maxLength){
                count += dpC[i];
            }
        }
        return count;
    }
    public static void main(String[] args) {
        NumberOfLongestIncreasingSubsequence numberOfLongestIncreasingSubsequence = new NumberOfLongestIncreasingSubsequence();
        System.out.println(numberOfLongestIncreasingSubsequence.findNumberOfLIS(new int[]{1,3,5,4,7}));//Output: 2
        System.out.println(numberOfLongestIncreasingSubsequence.findNumberOfLIS(new int[]{2,2,2,2,2}));//Output: 5
    }
}
