package main.java.com.leetcode.dp._329;

//https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
//https://www.youtube.com/watch?v=uLjO2LUlLN4
public class LongestIncreasingPathMatrix {
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int n = matrix.length;
        int m = matrix[0].length;
        int longestPath = 0;
        int[][] memo = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int longest = longestIncreasingPath(matrix, memo, n,m,i,j);
                longestPath = Math.max(longestPath, longest);
            }
        }


        return longestPath;
    }

    private int longestIncreasingPath(int[][] matrix, int[][] memo, int n, int m, int i, int j) {
        if(memo[i][j] > 0){
            return memo[i][j];
        }

        int max = 0;
        for (int[] direction : directions) {
            int x = direction[0] + i;
            int y = direction[1] + j;
            if(x > - 1 && y > -1 && x < n && y < m && matrix[x][y] > matrix[i][j]){
                int longest = longestIncreasingPath(matrix, memo, n, m, x, y);
                max = Math.max(max, longest);
            }
        }
        memo[i][j] = max+1;
        return memo[i][j];
    }

    public static void main(String[] args) {
        LongestIncreasingPathMatrix longestIncreasingPathMatrix = new LongestIncreasingPathMatrix();
        System.out.println(longestIncreasingPathMatrix.longestIncreasingPath(new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}}));
    }
}
