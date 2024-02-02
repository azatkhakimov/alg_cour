package main.java.com.leetcode._1074;

import java.util.HashMap;
import java.util.Map;

public class NumberofSubmatricesThatSumtoTarget {

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] ps = new int[r+1][c+1];
        for (int i = 1; i < r + 1; i++) {
            for (int j = 1; j < c+1; j++) {
                ps[i][j] = ps[i-1][j]+ps[i][j-1]-ps[i-1][j-1]+matrix[i-1][j-1];
            }
        }
        int count = 0;
        int currSum = 0;

        Map<Integer, Integer> h = new HashMap<>();

        for (int c1 = 1; c1 < c+1; c1++) {
            for (int c2 = c1; c2 < c+1; c2++) {
                h.clear();
                h.put(0,1);
                for (int row = 1; row < r+1; row++) {
                    currSum = ps[row][c2]-ps[row][c1-1];
                    count += h.getOrDefault(currSum-target, 0);
                    h.put(currSum, h.getOrDefault(currSum,0)+1);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        var n = new NumberofSubmatricesThatSumtoTarget();
        System.out.println(n.numSubmatrixSumTarget(new int[][]{{0,1,0},{1,1,1},{0,1,0}}, 0));//Output: 4
        System.out.println(n.numSubmatrixSumTarget(new int[][]{{1,-1},{-1,1}},0));//Output: 5
    }
}
