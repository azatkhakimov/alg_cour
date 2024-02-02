package main.java.com.leetcode._1626;

import java.util.Arrays;

public class BestTeamWithNoConflicts {

    public int bestTeamScore(int[] scores, int[] ages) {
        int n = ages.length;
        int[][] ageScorePair = new int[n][2];

        for (int i = 0; i < n; i++) {
            ageScorePair[i][0] = ages[i];
            ageScorePair[i][1] = scores[i];
        }

        Arrays.sort(ageScorePair, (a,b)->a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        return findMaxScore(ageScorePair);
    }

    private int findMaxScore(int[][] ageScorePair) {
        int n = ageScorePair.length;
        int answer = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = ageScorePair[i][1];
            answer  = Math.max(answer, dp[i]);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i-1; j >= 0; j--) {
                if(ageScorePair[i][1] >= ageScorePair[j][1]){
                    dp[i] = Math.max(dp[i], ageScorePair[i][1]+dp[j]);
                }
            }
            answer = Math.max(answer, dp[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        BestTeamWithNoConflicts bestTeamWithNoConflicts = new BestTeamWithNoConflicts();
        System.out.println(bestTeamWithNoConflicts.bestTeamScore(new int[]{1,3,5,10,15}, new int[]{1,2,3,4,5}));//Output: 34
        System.out.println(bestTeamWithNoConflicts.bestTeamScore(new int[]{4,5,6,5}, new int[]{2,1,2,1}));//Output: 16
        System.out.println(bestTeamWithNoConflicts.bestTeamScore(new int[]{1,2,3,5}, new int[]{8,9,10,1}));//Output: 6
    }
}
