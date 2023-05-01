package leetcode._1312;

import leetcode._2306.NamingaCompany;

public class MinimumInsertionStepstoMakeaStringPalindrome {

    public int minInsertions(String s) {
        int n = s.length();
        String sReverse = new StringBuilder(s).reverse().toString();
        int[][] memo = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                memo[i][j] = -1;
            }
        }
        return n - lcs(s, sReverse, n, n, memo);
    }

    private int lcs(String s1, String s2, int m, int n, int[][] memo) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (memo[m][n] != -1) {
            return memo[m][n];
        }
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return memo[m][n] = 1 + lcs(s1, s2, m - 1, n - 1, memo);
        }
        return memo[m][n] = Math.max(lcs(s1, s2, m - 1, n, memo), lcs(s1, s2, m, n - 1, memo));

    }


    public static void main(String[] args) {
        MinimumInsertionStepstoMakeaStringPalindrome m = new MinimumInsertionStepstoMakeaStringPalindrome();
        System.out.println(m.minInsertions("zzazz"));//0
        System.out.println(m.minInsertions("mbadm"));//Output: 2
        System.out.println(m.minInsertions("leetcode"));//Output: 5
    }
}
