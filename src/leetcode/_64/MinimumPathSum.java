package leetcode._64;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }

        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                dp[i][j] += grid[i][j];
                if(i > 0 && j > 0){
                    dp[i][j] += Math.min(dp[i-1][j], dp[i][j-1]);
                } else if (i>0) {
                    dp[i][j] += dp[i-1][j];
                } else if (j > 0) {
                    dp[i][j] += dp[i][j-1];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }


    public static void main(String[] args) {
        MinimumPathSum m = new MinimumPathSum();
        System.out.println(m.minPathSum(new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        }));//Output: 7
        System.out.println(m.minPathSum(new int[][]{
                {1, 2, 3},
                {4, 5, 6}
        }));//Output: 12
    }
}
