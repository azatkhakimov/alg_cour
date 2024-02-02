package main.java.com.leetcode._200;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                count += dfs(row, col, grid);
            }
        }
        return count;
    }

    private int dfs(int row, int col, char[][] grid) {
        if(row < 0 || row >= grid.length){
            return 0;
        }
        if(col < 0 || col >= grid[0].length){
            return 0;
        }

        if(grid[row][col] == '0'){
            return 0;
        }

        grid[row][col] = '0';
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        for (int[] dir : dirs) {
            int rowDir = dir[0];
            int colDir = dir[1];
            dfs(row+rowDir, col+colDir, grid);
        }

        return 1;
    }


    public static void main(String[] args) {
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        System.out.println(numberOfIslands.numIslands(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        }));//Output: 1
        System.out.println(numberOfIslands.numIslands(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        }));//Output: 3
    }
}
