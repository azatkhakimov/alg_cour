package leetcode.array._1074;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubmatricesThatSumToTarget {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int result = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 1; col < n; col++) {
                matrix[row][col] += matrix[row][col-1];
            }
        }
        Map<Integer, Integer> counter = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for(int j = i; j < n; j++){
                counter.clear();
                counter.put(0,1);
                int curr = 0;
                for (int k = 0; k < m; k++) {
                    curr += matrix[k][j]-(i>0?matrix[k][i-1]:0);
                    result += counter.getOrDefault(curr-target, 0);
                    counter.put(curr, counter.getOrDefault(curr, 0)+1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        NumberOfSubmatricesThatSumToTarget test = new NumberOfSubmatricesThatSumToTarget();
        System.out.println(test.numSubmatrixSumTarget(new int[][]{{0,1,0},{1,1,1},{0,1,0}}, 0));//Output: 4
        System.out.println(test.numSubmatrixSumTarget(new int[][]{{1,-1},{-1,1}}, 0));//Output: 5
    }
}
