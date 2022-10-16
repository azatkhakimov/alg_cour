package leetcode._1531;

import java.util.Arrays;
import java.util.Map;

public class StringCompressionII {
    public int getLengthOfOptimalCompression(String s, int k) {
        char[] chars = s.toCharArray();
        int[][] dp = new int[s.length()][k+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dfs(chars, 0, k, dp);
    }

    private int dfs(char[] s, int curIndex, int k, int[][] dp) {
        if(curIndex == s.length || s.length - curIndex <= k){
            return 0;
        }
        if(dp[curIndex][k] != -1){
            return dp[curIndex][k];
        }
        int[] frequency = new int[26];
        int most = 0;
        int res = Integer.MAX_VALUE;

        for (int i = curIndex; i < s.length; i++) {
            int idx = s[i]-'a';
            frequency[idx]++;

            most = Math.max(most, frequency[idx]);
            if(k >= i-curIndex+1-most){
                res = Math.min(res, getLength(most)+1+dfs(s, i+1, k-(i-curIndex+1-most), dp));
            }
        }
        dp[curIndex][k] = res;
        return res;
    }

    private int getLength(int most) {
        if(most == 1){
            return 0;
        }
        if(most < 10){
            return 1;
        }
        if(most < 99){
            return 2;
        }
        return 3;
    }

    public static void main(String[] args) {
        StringCompressionII stringCompression = new StringCompressionII();
        System.out.println(stringCompression.getLengthOfOptimalCompression("aaabcccd", 2));//Output: 4
        System.out.println(stringCompression.getLengthOfOptimalCompression("aabbaa", 2));//Output: 2
        System.out.println(stringCompression.getLengthOfOptimalCompression("aaaaaaaaaaa", 0));//Output: 3
    }
}
