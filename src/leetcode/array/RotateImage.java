package leetcode.array;

import java.util.Arrays;

public class RotateImage {
    public void rotate(int[][] matrix){
        transpose(matrix);
        reverse(matrix);
    }
    public void transpose(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
              int temp = matrix[j][i];
              matrix[j][i] = matrix[i][j];
              matrix[i][j] = temp;
            }
        }
    }

    public void reverse(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        RotateImage rotateImage = new RotateImage();
        rotateImage.rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }
}
