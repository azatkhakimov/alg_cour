package leetcode._1254;

public class NumberOfClosedIslands {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visit = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0 && !visit[i][j] && dfs(i, j, m, n, grid, visit)){
                    count++;
                }
            }
        }
        return count;
    }

    private boolean dfs(int x, int y, int m, int n, int[][] grid, boolean[][] visit) {
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length){
            return false;
        }
        if(grid[x][y] == 1 || visit[x][y]){
            return true;
        }
        visit[x][y] = true;
        boolean isClosed = true;
        int[] dirX = {0, 1, 0, -1};
        int [] dirY = {-1, 0, 1, 0};
        for (int i = 0; i < 4; i++) {
            int r = x + dirX[i];
            int c = y + dirY[i];
            if(!dfs(r, c, m, n, grid, visit)){
                isClosed = false;
            }
        }
        return isClosed;
    }

    public static void main(String[] args) {
        NumberOfClosedIslands n = new NumberOfClosedIslands();
        System.out.println(n.closedIsland(new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0}
        }));//Output: 2
        System.out.println(n.closedIsland(new int[][]{
                {0, 0, 1, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 1, 1, 1, 0}
        }));//Output: 1
        System.out.println(n.closedIsland(new int[][]{
                {1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1}
        }));//Output: 2
    }
}
