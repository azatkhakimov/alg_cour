package main.java.com.leetcode._980;

public class UniquePathsIII {
    int res = 0;
    int empty = 1;
    int sx;
    int sy;

    public int uniquePathsIII(int[][] grid) {
        int x = 0, y = 0, empty = 0;
        for(int i=0; i < grid.length; i++)
            for(int j=0; j < grid[0].length; j++)
                if(grid[i][j] == 0)
                    ++empty;
                else if(grid[i][j] == 1){
                    x = i;
                    y = j;
                }

        return dfs(grid, x, y, -1, empty);
    }

    private int dfs(int[][] grid, int i, int j, int count, int need){
        if(i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] == -1) return 0;
        if(grid[i][j] == 2){
            if(count == need)
                return 1;
            else
                return 0;
        }
        grid[i][j] = -1;
        int total = dfs(grid, i-1, j, count+1, need);
        total += dfs(grid, i, j+1, count+1, need);
        total += dfs(grid, i+1, j, count+1, need);
        total += dfs(grid, i, j-1, count+1, need);
        grid[i][j] = 0;
        return total;
    }

    public static void main(String[] args) {
        UniquePathsIII path = new UniquePathsIII();
        System.out.println(path.uniquePathsIII(new int[][]{
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, -1}
        }));//Output: 2

        System.out.println(path.uniquePathsIII(new int[][]{
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 2}
        }));//Output: 4

        System.out.println(path.uniquePathsIII(new int[][]{
                {0, 1},
                {2, 0}
        }));//Output: 0
    }
}
