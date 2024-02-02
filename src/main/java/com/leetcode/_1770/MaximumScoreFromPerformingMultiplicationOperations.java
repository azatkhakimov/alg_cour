package main.java.com.leetcode._1770;

public class MaximumScoreFromPerformingMultiplicationOperations {
    public int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length;
        int m = multipliers.length;
        int[] dp = new int[m+1];
        for(int op = m-1; op >= 0; op--){
            int[] nextRow = dp.clone();
            for (int left = op; left >= 0; left--) {
                dp[left] = Math.max(multipliers[op]*nums[left] + nextRow[left+1],
                        multipliers[op]*nums[n-1-(op-left)]+nextRow[left]);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        MaximumScoreFromPerformingMultiplicationOperations test = new MaximumScoreFromPerformingMultiplicationOperations();
        System.out.println(test.maximumScore(new int[]{1,2,3},new int[]{3,2,1}));//Output: 14
        System.out.println(test.maximumScore(new int[]{-5,-3,-3,-2,7,1}, new int[]{-10,-5,3,4,6}));//Output: 102
    }
}
