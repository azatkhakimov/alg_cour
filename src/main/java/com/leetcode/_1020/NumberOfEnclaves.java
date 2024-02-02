package main.java.com.leetcode._1020;

public class NumberOfEnclaves {

    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visit = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1 && !visit[i][0]) {
                dfs(i, 0, m, n, grid, visit);
            }
            if (grid[i][n - 1] == 1 && !visit[i][n - 1]) {
                dfs(i, n - 1, m, n, grid, visit);
            }
        }

        for (int i = 0; i < n; i++) {
            if (grid[0][i] == 1 && !visit[0][i]) {
                dfs(0, i, m, n, grid, visit);
            }
            if (grid[m - 1][i] == 1 && !visit[m - 1][i]) {
                dfs(m - 1, i, m, n, grid, visit);
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visit[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int x, int y, int m, int n, int[][] grid, boolean[][] visit) {
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0 || visit[x][y]) {
            return;
        }
        visit[x][y] = true;
        int[] dirX = {0, 1, 0, -1};
        int[] dirY = {-1, 0, 1, 0};
        for (int i = 0; i < 4; i++) {
            dfs(x + dirX[i], y + dirY[i], m, n, grid, visit);
        }

    }

    public static void main(String[] args) {
        NumberOfEnclaves n = new NumberOfEnclaves();
        System.out.println(n.numEnclaves(new int[][]{
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        }));//Output: 3
        System.out.println(n.numEnclaves(new int[][]{
                {0, 1, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0}
        }));//Output: 0
    }
}
