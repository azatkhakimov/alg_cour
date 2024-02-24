package main.java.com.leetcode._1639;

public class NumberOfWaysToFormaTargetStringGivenaDictionary {
    public int numWays(String[] words, String target) {
        int alphabet = 26;
        int mod = 1000000007;
        int m = target.length();
        int k = words[0].length();
        int[][] cnt = new int[alphabet][k];
        for (int j = 0; j < k; j++) {
            for (String word : words) {
                cnt[word.charAt(j)-'a'][j]++;
            }
        }
        long[][] dp = new long[m+1][k+1];
        dp[0][0] = 1;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j < k; j++) {
                if(i < m){
                    dp[i+1][j+1] += cnt[target.charAt(i)-'a'][j]*dp[i][j];
                    dp[i+1][j+1] %= mod;
                }
                dp[i][j+1] += dp[i][j];
                dp[i][j+1] %= mod;
            }
        }
        return (int) dp[m][k];
    }

    public static void main(String[] args) {
        NumberOfWaysToFormaTargetStringGivenaDictionary n = new NumberOfWaysToFormaTargetStringGivenaDictionary();
        System.out.println(n.numWays(new String[]{"acca","bbbb","caca"},
                "aba"));//Output: 6
        System.out.println(n.numWays(new String[]{"abba","baab"},
                "bab"));//Output: 4
    }
}