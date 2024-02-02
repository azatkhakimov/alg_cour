package main.java.com.leetcode._1572;

public class MatrixDiagonalSum {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer += mat[i][i];
            answer += mat[n-1-i][i];
        }
        if(n % 2 != 0){
            answer -= mat[n/2][n/2];
        }
        return answer;
    }

    public static void main(String[] args) {
        var m = new MatrixDiagonalSum();
        System.out.println(m.diagonalSum(
                new int[][]{
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                }
        ));//Output: 25
        System.out.println(m.diagonalSum(
                new int[][]{
                        {1, 1, 1, 1},
                        {1, 1, 1, 1},
                        {1, 1, 1, 1},
                        {1, 1, 1, 1}
                }
        ));//Output: 8
    }
}
