package main.java.com.leetcode._867;

import java.util.Arrays;

public class TransposeMatrix {

    public int[][] transpose(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] ans = new int[c][r];
        for (int row = 0; row < r; row++) {
            for (int col = 0; col < c; col++) {
                ans[col][row] = matrix[row][col];
            }
        }
        return ans;
     }
    public static void main(String[] args) {
        var t = new TransposeMatrix();
        System.out.println(Arrays.deepToString(t.transpose(new int[][]{{1,2,3},{4,5,6},{7,8,9}})));//Output: [[1,4,7],[2,5,8],[3,6,9]]
        System.out.println(Arrays.deepToString(t.transpose(new int[][]{{1,2,3},{4,5,6}})));//[[1,4],[2,5],[3,6]]
    }
}
