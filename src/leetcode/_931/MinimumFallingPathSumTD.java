package leetcode._931;

public class MinimumFallingPathSumTD {
    public int minFallingPathSum(int[][] matrix) {
        int minFallingSum = Integer.MAX_VALUE;
        Integer[][] memo = new Integer[matrix.length][matrix[0].length];

        for (int startCol = 0; startCol < matrix.length; startCol++) {
            minFallingSum = Math.min(minFallingSum, findMinFallingPathSum(matrix, 0, startCol, memo));
        }
        return minFallingSum;
    }

    private int findMinFallingPathSum(int[][] matrix, int row, int col, Integer[][] memo) {
        if(col < 0 || col == matrix.length){
            return Integer.MAX_VALUE;
        }

        if(row == matrix.length-1){
            return matrix[row][col];
        }
        if(memo[row][col] != null){
            return memo[row][col];
        }

        int left = findMinFallingPathSum(matrix, row+1, col, memo);
        int middle = findMinFallingPathSum(matrix, row+1, col+1, memo);
        int right = findMinFallingPathSum(matrix, row+1, col-1, memo);
        memo[row][col] = Math.min(left, Math.min(middle, right))+matrix[row][col];
        return memo[row][col];
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
