package main.java.com.leetcode._576;

public class OutofBoundaryPaths {

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int M = 1000000000 + 7;
        int dp[][] = new int[m][n];
        dp[startRow][startColumn] = 1;
        int count = 0;
        for (int moves = 1; moves <= maxMove; moves++) {
            int[][] temp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == m - 1) count = (count + dp[i][j]) % M;
                    if (j == n - 1) count = (count + dp[i][j]) % M;
                    if (i == 0) count = (count + dp[i][j]) % M;
                    if (j == 0) count = (count + dp[i][j]) % M;
                    temp[i][j] = (
                            ((i > 0 ? dp[i - 1][j] : 0) + (i < m - 1 ? dp[i + 1][j] : 0)) % M +
                                    ((j > 0 ? dp[i][j - 1] : 0) + (j < n - 1 ? dp[i][j + 1] : 0)) % M
                    ) % M;
                }
            }
            dp = temp;
        }
        return count;
    }

    public static void main(String[] args) {
        var o = new OutofBoundaryPaths();
        System.out.println(o.findPaths(2, 2, 2, 0, 0));//Output: 6
        System.out.println(o.findPaths(1, 3, 3, 0, 1));
    }
}
