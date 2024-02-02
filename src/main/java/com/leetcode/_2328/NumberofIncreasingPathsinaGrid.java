package main.java.com.leetcode._2328;

public class NumberofIncreasingPathsinaGrid {
    private static final int MOD = 1_000_000_007;
    int[][] dp;

    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int countPaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m][n];
        int answer = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                answer = (answer + dfs(grid, i, j))%MOD;
            }
        }
        return answer;
    }

    private int dfs(int[][] grid, int i, int j) {
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        int answer = 1;
        for (int[] direction : directions) {
            int prevI = i + direction[0];
            int prevJ = j + direction[1];
            if(0 <= prevI && prevI < grid.length && 0 <= prevJ
                    && prevJ < grid[0].length && grid[prevI][prevJ] < grid[i][j]){
                answer += dfs(grid, prevI, prevJ);
                answer %= MOD;
            }
        }
        dp[i][j] = answer;
        return answer;

    }


    public static void main(String[] args) {
        var n = new NumberofIncreasingPathsinaGrid();
        System.out.println(n.countPaths(new int[][]{
                {1, 1},
                {3, 4}
        }));//Output: 8

        System.out.println(n.countPaths(new int[][]{
                {1},
                {2}
        }));//Output: 3
    }
}
