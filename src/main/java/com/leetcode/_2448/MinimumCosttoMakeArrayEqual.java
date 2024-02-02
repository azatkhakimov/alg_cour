package main.java.com.leetcode._2448;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumCosttoMakeArrayEqual {


    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        int[][] numsAndCost = new int[n][2];
        for (int i = 0; i < n; i++) {
            numsAndCost[i][0] = nums[i];
            numsAndCost[i][1] = cost[i];
        }
        Arrays.sort(numsAndCost, Comparator.comparingInt(a -> a[0]));
        long[] prefixCost = new long[n];
        prefixCost[0] = numsAndCost[0][1];
        for (int i = 1; i < n; i++) {
            prefixCost[i] = numsAndCost[i][1]+prefixCost[i-1];
        }
        long totalCost = 0l;
        for (int i = 1; i < n; i++) {
            totalCost += (long) numsAndCost[i][1] * (numsAndCost[i][0] - numsAndCost[0][0]);
        }
        long answer = totalCost;
        for (int i = 1; i < n; i++) {
            int gap = numsAndCost[i][0] - numsAndCost[i - 1][0];
            totalCost += prefixCost[i-1]*gap;
            totalCost -= (prefixCost[n-1]-prefixCost[i-1])*gap;
            answer = Math.min(answer, totalCost);
        }
        return answer;
    }

    public static void main(String[] args) {
        var m = new MinimumCosttoMakeArrayEqual();
        System.out.println(m.minCost(new int[]{1,3,5,2}, new int[] {2,3,1,14}));//Output: 8
        System.out.println(m.minCost(new int[]{2,2,2,2,2}, new int[] {4,2,8,1,3}));//Output: 0
    }
}
