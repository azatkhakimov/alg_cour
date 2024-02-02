package main.java.com.leetcode._931;

public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] arr = new int[m][n];
        for (int j = 0; j < n; j++) {
            arr[0][j] = matrix[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(j == 0){
                    arr[i][j] = Math.min(arr[i-1][j], arr[i-1][j+1]);
                } else if (j == n-1) {
                    arr[i][j] = Math.min(arr[i-1][j-1], arr[i-1][j]);
                }else {
                    arr[i][j] = Math.min(arr[i-1][j-1], arr[i-1][j]);
                    arr[i][j] = Math.min(arr[i][j], arr[i-1][j+1]);
                }
                arr[i][j] += matrix[i][j];
            }
        }
        int min = Integer.MAX_VALUE;
        for (int num : arr[m - 1]) {
            min = Math.min(min, num);
        }
        return min;
    }

    public static void main(String[] args) {
        MinimumFallingPathSum sum = new MinimumFallingPathSum();
        System.out.println(sum.minFallingPathSum(new int[][]{
                {2,1,3},
                {6,5,4},
                {7,8,9}
        }));//Output: 13

        System.out.println(sum.minFallingPathSum(new int[][]{
                {-19,57},
                {-40,-5}
        }));//Output: -59
    }
}
