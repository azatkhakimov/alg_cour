package leetcode._48;

public class RotateImage {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverse(matrix);
    }

    public void transpose(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
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
        rotateImage.rotate(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });//Output: [[7,4,1],[8,5,2],[9,6,3]]

        rotateImage.rotate(new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        });//Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]ma
    }
}
