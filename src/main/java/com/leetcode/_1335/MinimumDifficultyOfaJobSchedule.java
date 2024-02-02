package main.java.com.leetcode._1335;

import java.util.Arrays;

public class MinimumDifficultyOfaJobSchedule {
    public int minDifficulty(int[] jobDifficulty, int d) {
        if(d > jobDifficulty.length){
            return -1;
        }
        int[][] dp = new int[d+1][jobDifficulty.length];
        for (int[] num : dp) {
            Arrays.fill(num, -1);
        }
        return dfs(jobDifficulty, d, dp, 0);

    }

    private int dfs(int[] jobDifficulty, int d, int[][] dp, int idx) {
        if(d == 1){
            int max = 0;
            while (idx < jobDifficulty.length){
                max = Math.max(max, jobDifficulty[idx++]);
            }
            return max;
        }
        if(dp[d][idx] != -1){
            return dp[d][idx];
        }
        int max = 0;
        int res  = Integer.MAX_VALUE;
        for (int i = idx; i < jobDifficulty.length - d + 1; i++) {
            max = Math.max(max, jobDifficulty[i]);
            res = Math.min(res, max+dfs(jobDifficulty, d-1, dp, i+1));
        }
        return dp[d][idx] = res;
    }


    public static void main(String[] args) {
        MinimumDifficultyOfaJobSchedule minimumDifficultyOfaJobSchedule = new MinimumDifficultyOfaJobSchedule();
        System.out.println(minimumDifficultyOfaJobSchedule.minDifficulty(new int[]{6,5,4,3,2,1},  2));//Output: 7
        System.out.println(minimumDifficultyOfaJobSchedule.minDifficulty(new int[]{9,9,9}, 4));//Output: -1
        System.out.println(minimumDifficultyOfaJobSchedule.minDifficulty(new int[]{1,1,1}, 3));//Output: 3
    }
}
