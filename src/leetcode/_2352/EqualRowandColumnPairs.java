package leetcode._2352;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EqualRowandColumnPairs {

    public int equalPairs(int[][] grid) {
        int sum = 0;
        int n = grid.length;
        Map<String, Integer> rowCounter = new HashMap<>();
        for (int[] row : grid) {
            String rowStr = Arrays.toString(row);
            rowCounter.put(rowStr, rowCounter.getOrDefault(rowStr, 0)+1);

        }

        for (int c = 0; c < n; c++) {
            int[] colArray = new int[n];
            for (int r = 0; r < n; r++) {
                colArray[r] = grid[r][c];
            }
            sum += rowCounter.getOrDefault(Arrays.toString(colArray),0);
        }
        return sum;
    }

    public static void main(String[] args) {
        var e = new EqualRowandColumnPairs();
        System.out.println(e.equalPairs(
                new int[][]{
                        {3, 2, 1},
                        {1, 7, 6},
                        {2, 7, 7}}
        ));//Output: 1
        System.out.println(e.equalPairs(
                new int[][]{
                        {3, 1, 2, 2},
                        {1, 4, 4, 5},
                        {2, 4, 2, 2},
                        {2, 4, 2, 2}}
        ));//Output: 3
    }
}
