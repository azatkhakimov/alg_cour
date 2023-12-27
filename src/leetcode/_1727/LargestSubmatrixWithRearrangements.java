package leetcode._1727;

import leetcode._863.AllNodesDistanceKinBinaryTree;

import java.util.Arrays;

public class LargestSubmatrixWithRearrangements {

    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 0;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if(matrix[row][col] != 0 && row > 0){
                    matrix[row][col] += matrix[row-1][col];
                }
            }

            int[] curRow = matrix[row].clone();
            Arrays.sort(curRow);
            for (int i = 0; i < n; i++) {
                ans = Math.max(ans, curRow[i] * (n-i));

            }
        }
        return ans;
    }

    public static void main(String[] args) {
        var l = new LargestSubmatrixWithRearrangements();
        System.out.println(l.largestSubmatrix(new int[][]{{0,0,1},{1,1,1},{1,0,1}}));//Output: 4
        System.out.println(l.largestSubmatrix(new int[][]{{1,0,1,0,1}}));//Output: 3
        System.out.println(l.largestSubmatrix(new int[][]{{1,1,0},{1,0,1}}));//Output: 2
    }
}
