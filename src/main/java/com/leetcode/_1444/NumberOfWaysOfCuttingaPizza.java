package main.java.com.leetcode._1444;

public class NumberOfWaysOfCuttingaPizza {
    public int ways(String[] pizza, int k) {
        int rows = pizza.length;
        int cols = pizza[0].length();
        int[][] apples = new int[rows+1][cols+1];
        int [][][] dp = new int[k][rows][cols];
        for (int row = rows-1; row >= 0; row--) {
            for (int col = cols-1; col >= 0; col--) {
               apples[row][col] = (pizza[row].charAt(col) == 'A'
                       ? 1 : 0) + apples[row+1][col] + apples[row][col+1]
               - apples[row+1][col+1];
                dp[0][row][col] = apples[row][col] > 0 ? 1 : 0;
            }
        }
        int mod = 1000000007;
        for (int remain = 1; remain < k; remain++) {
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    for (int nextRow = row + 1; nextRow < rows; nextRow++) {
                        if(apples[row][col] - apples[nextRow][col] > 0){
                            dp[remain][row][col] += dp[remain-1][nextRow][col];
                            dp[remain][row][col] %= mod;
                        }
                    }

                    for(int nextCol = col+1; nextCol < cols; nextCol++){
                        if(apples[row][col] - apples[row][nextCol] > 0){
                            dp[remain][row][col] += dp[remain-1][row][nextCol];
                            dp[remain][row][col] %= mod;
                        }
                    }
                }
            }
        }
        return dp[k-1][0][0];
    }

    public static void main(String[] args) {
        NumberOfWaysOfCuttingaPizza n = new NumberOfWaysOfCuttingaPizza();
        System.out.println(n.ways(new String[]{"A..", "AAA", "..."}, 3));//Output: 3
        System.out.println(n.ways(new String[]{"A..","AA.","..."}, 3));//Output: 1
        System.out.println(n.ways(new String[]{"A..","A..","..."}, 1));//Output: 1
    }
}
