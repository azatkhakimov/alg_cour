package leetcode.array.matrix._867;

import java.util.Arrays;

public class TransposeMatrix {
    public int[][] transpose(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] ans = new int[col][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++){
                ans[j][i] = matrix[i][j];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TransposeMatrix transposeMatrix = new TransposeMatrix();
        int[][] transpose = transposeMatrix.transpose(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        System.out.println(Arrays.deepToString(transpose));//[[1,4,7],[2,5,8],[3,6,9]]
        System.out.println(Arrays.deepToString(transposeMatrix.transpose(new int[][]{{1,2,3},{4,5,6}})));
    }
}
