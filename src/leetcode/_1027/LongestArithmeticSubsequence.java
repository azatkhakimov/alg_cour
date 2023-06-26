package leetcode._1027;

import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequence {


    public int longestArithSeqLength(int[] nums) {
        int maxLength = 0;
        Map<Integer, Integer>[] dp = new HashMap[nums.length];
        for (int right = 0; right < nums.length; right++) {
            dp[right] = new HashMap<>();
            for (int left = 0; left < right; left++) {
                int diff = nums[left] - nums[right];
                dp[right].put(diff, dp[left].getOrDefault(diff, 1) + 1);
                maxLength = Math.max(maxLength, dp[right].get(diff));
            }
        }
        return maxLength;
    }


    public static void main(String[] args) {
        var l = new LongestArithmeticSubsequence();
        System.out.println(l.longestArithSeqLength(new int[]{3, 6, 9, 12}));//Output: 4
        System.out.println(l.longestArithSeqLength(new int[]{9, 4, 7, 2, 10}));//Output: 3
        System.out.println(l.longestArithSeqLength(new int[]{20, 1, 15, 3, 10, 5, 8}));//Output: 4
    }
}
