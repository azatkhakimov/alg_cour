package leetcode._2482;

import java.util.Arrays;

public class DifferenceBetweenOnesAndZerosInRowAndColumn {

    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] onesRow = new int[m];
        int[] onesCol = new int[n];
        Arrays.fill(onesRow, 0);
        Arrays.fill(onesCol, 0);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                onesRow[i] += grid[i][j];
                onesCol[j] += grid[i][j];
            }
        }

        int[][] diff = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                diff[i][j] = 2 * onesRow[i] + 2 * onesCol[j] - n - m;
            }
        }
        return diff;
    }

    public static void main(String[] args) {
        var d = new DifferenceBetweenOnesAndZerosInRowAndColumn();
        System.out.println(Arrays.deepToString(d.onesMinusZeros(new int[][]{{0,1,1},{1,0,1},{0,0,1}})));//Output: [[0,0,4],[0,0,4],[-2,-2,2]]
        System.out.println(Arrays.deepToString(d.onesMinusZeros(new int[][]{{0,1,1},{1,0,1},{0,0,1}})));//Output: [[0,0,4],[0,0,4],[-2,-2,2]]
    }
}
