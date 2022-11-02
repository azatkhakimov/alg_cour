package leetcode._766;

public class ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[0].length; col++){
                if(row > 0 && col > 0 && matrix[row-1][col-1] != matrix[row][col]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ToeplitzMatrix toeplitzMatrix = new ToeplitzMatrix();
        System.out.println(toeplitzMatrix.isToeplitzMatrix(new int[][]{
                {1, 2, 3, 4},
                {5, 1, 2, 3},
                {9, 5, 1, 2}
        }));//Output: true
        System.out.println(toeplitzMatrix.isToeplitzMatrix(new int[][]{
                {1, 2},
                {2, 2}
        }));//Output: false
    }
}
