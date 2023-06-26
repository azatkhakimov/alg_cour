package leetcode._73;

import java.util.Arrays;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix){
        boolean isCol = false;
        int row = matrix.length;
        int col = matrix[0].length;

        for(int i = 0; i < row; i++){
            if(matrix[i][0] == 0){
                isCol = true;
            }

            for(int j = 1; j < col; j++){
                if (matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                if (matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if (matrix[0][0] == 0){
            for (int j = 0; j < col; j++){
                matrix[0][j] = 0;
            }
        }

        if(isCol){
            for(int i = 0; i < row; i++){
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};

        SetMatrixZeroes setMatrixZeroes = new SetMatrixZeroes();
        setMatrixZeroes.setZeroes(matrix);
        System.out.println(Arrays.deepToString((matrix)));
    }
}
