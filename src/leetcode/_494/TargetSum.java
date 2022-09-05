package leetcode._494;

import java.util.Arrays;

public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        int total = Arrays.stream(nums).sum();
        int[] dp = new int[2 * total + 1];
        dp[nums[0] + total] = 1;
        dp[-nums[0] + total] += 1;
        for (int i = 1; i < nums.length; i++) {
            int[] next = new int[2 * total + 1];
            for (int sum = -total; sum <= total; sum++) {
                if (dp[sum + total] > 0) {
                    next[sum + nums[i] + total] += dp[sum + total];
                    next[sum - nums[i] + total] += dp[sum + total];
                }
            }
            dp = next;
        }
        return Math.abs(target) > total ? 0 : dp[target + total];
    }

    public static void main(String[] args) {
        TargetSum targetSum = new TargetSum();
        System.out.println(targetSum.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
        /*Output: 5
Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3*/
        System.out.println(targetSum.findTargetSumWays(new int[]{1}, 1));//Output: 1
    }
}
