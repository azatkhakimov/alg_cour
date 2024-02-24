package main.java.com.leetcode._1463;

public class CherryPickupII {

    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][][] = new int[m][n][n];

        for (int row = m-1; row >= 0; row--) {
            for (int col1 = 0; col1 < n; col1++) {
                for (int col2 = 0; col2 < n; col2++) {
                    int result = 0;
                    result += grid[row][col1];
                    if(col1 != col2){
                        result+=grid[row][col2];
                    }

                    if(row != m-1){
                        int max = 0;
                        for (int newCol1 = col1-1; newCol1 <= col1 + 1; newCol1++) {
                            for (int newCol2 = col2-1; newCol2 <= col2+1; newCol2++) {
                                if(newCol1 >= 0 && newCol1 < n && newCol2 >= 0 && newCol2 < n){
                                    max = Math.max(max, dp[row+1][newCol1][newCol2]);
                                }
                            }
                        }
                        result += max;
                    }
                    dp[row][col1][col2] = result;
                }
            }
        }
        return dp[0][0][n-1];
    }

    public static void main(String[] args) {
        var c = new CherryPickupII();
        System.out.println(c.cherryPickup(new int[][]{{3,1,1},{2,5,1},{1,5,5},{2,1,1}}));//Output: 24
        System.out.println(c.cherryPickup(new int[][]{{1,0,0,0,0,0,1},{2,0,0,0,0,3,0},{2,0,9,0,0,0,0},
                {0,3,0,5,4,0,0},{1,0,2,3,0,0,6}}));//Output: 28
    }
}
