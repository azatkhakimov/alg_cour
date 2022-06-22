package leetcode.array._240;

public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }

        int row = 0;
        int col = matrix[0].length - 1;
        while(row < matrix.length && col >= 0){
            if(target == matrix[row][col]){
                return true;
            }else if(target > matrix[row][col]){
                row++;
            }else if(target < matrix[row][col]){
                col--;
            }
        }
        return false;
    }
}