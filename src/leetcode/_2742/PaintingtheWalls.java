package leetcode._2742;

public class PaintingtheWalls {


    public int paintWalls(int[] cost, int[] time) {
            int n = cost.length;
            int[][] dp = new int[n+1][n+1];
            for (int i = 1; i <= n; i++) {
                dp[n][i] = (int)1e9;
            }

            for (int i = n-1; i >= 0; i--) {
                for (int remain = 1; remain <= n; remain++) {
                    int paint = cost[i] + dp[i+1][Math.max(0, remain - 1 - time[i])];
                    int dontPaint = dp[i+1][remain];
                    dp[i][remain] = Math.min(paint, dontPaint);
                }
            }
            return dp[0][n];
    }


    public static void main(String[] args) {
        var p = new PaintingtheWalls();
        System.out.println(p.paintWalls(new int[]{1, 2, 3, 2}, new int[]{1, 2, 3, 2}));//Output: 3
        System.out.println(p.paintWalls(new int[]{2, 3, 4, 2}, new int[]{1, 1, 1, 1}));//Output: 4
    }
}
