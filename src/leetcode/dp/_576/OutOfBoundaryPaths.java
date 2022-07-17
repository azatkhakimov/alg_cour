package leetcode.dp._576;

public class OutOfBoundaryPaths {
    private static final int MOD = 1000000007;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if (m < 0 || n < 0 || maxMove < 0 || startRow < 0 || startColumn < 0) {
            return 0;
        }

        Long[][][] dp = new Long[m][n][maxMove+1];
        return (int) dfs(m, n, maxMove, startRow, startColumn, dp);
    }

    private long dfs(int m, int n, int maxMove, int startRow, int startColumn, Long[][][] dp) {
        if (startRow < 0 || startColumn < 0 || startRow >= m || startColumn >= n) {
            return 1;
        }
        if (maxMove < 1) {
            return 0;
        }
        if (dp[startRow][startColumn][maxMove] != null) {
            return dp[startRow][startColumn][maxMove];
        }
        long down = dfs(m, n, maxMove - 1, startRow + 1, startColumn, dp);
        long up = dfs(m, n, maxMove - 1, startRow - 1, startColumn, dp);
        long left = dfs(m, n, maxMove - 1, startRow, startColumn - 1, dp);
        long right = dfs(m, n, maxMove - 1, startRow, startColumn + 1, dp);
        dp[startRow][startColumn][maxMove] = (down + up + left + right) % MOD;
        return dp[startRow][startColumn][maxMove];
    }

    public static void main(String[] args) {
        OutOfBoundaryPaths outOfBoundaryPaths = new OutOfBoundaryPaths();
        System.out.println(outOfBoundaryPaths.findPaths(2, 2, 2, 0, 0));//Output: 6
        System.out.println(outOfBoundaryPaths.findPaths(1, 3, 3, 0, 1));//Output: 12
    }
}
