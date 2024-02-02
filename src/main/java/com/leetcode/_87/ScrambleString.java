package main.java.com.leetcode._87;

public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        boolean[][][] dp = new boolean[n+1][n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[1][i][j] = s1.charAt(i) == s2.charAt(j);
            }
        }

        for (int length = 2; length <= n; length++) {
            for (int i = 0; i < n + 1 - length; i++) {
                for (int j = 0; j < n + 1 - length; j++) {
                    for (int newLength = 1; newLength < length; newLength++) {
                        boolean dp1[] = dp[newLength][i];
                        boolean dp2[] = dp[length - newLength][i + newLength];
                        dp[length][i][j] |= dp1[j] && dp2[j + newLength];
                        dp[length][i][j] |= dp1[j + length - newLength] && dp2[j];
                    }
                }
            }
        }
        return dp[n][0][0];
    }

    public static void main(String[] args) {
        ScrambleString s = new ScrambleString();
        System.out.println(s.isScramble("great", "rgeat"));//Output: true
        System.out.println(s.isScramble("abcde", "caebd"));//Output: false
        System.out.println(s.isScramble("a", "a"));//Output: true
    }
}
