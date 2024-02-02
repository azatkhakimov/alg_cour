package main.java.com.leetcode._1155;

public class NumberOfDiceRollsWithTargetSum {
    private int MOD = 1_000_000_007;

    public int numRollsToTarget(int n, int k, int target) {
        long[] dp = new long[target+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = target; j >= 0; j--) {
                dp[j] = 0;
                for (int b = 1; b <= k; b++) {
                    if(j >= b){
                        dp[j] = (dp[j]+dp[j-b])%MOD;
                    }else {
                        break;
                    }
                }
            }
        }
        return (int)dp[target];
    }

    public static void main(String[] args) {
        NumberOfDiceRollsWithTargetSum numberOfDiceRollsWithTargetSum = new NumberOfDiceRollsWithTargetSum();
        System.out.println(numberOfDiceRollsWithTargetSum.numRollsToTarget(1,6,3));//Output: 1
        System.out.println(numberOfDiceRollsWithTargetSum.numRollsToTarget(2,6,7));//Output: 6
        System.out.println(numberOfDiceRollsWithTargetSum.numRollsToTarget(30, 30, 500));//Output: 222616187
    }
}
