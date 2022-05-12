package leetcode.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PacificAtlanticWaterFlow {
    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new LinkedList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }

        int row = heights.length;
        int col = heights[0].length;
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            dfs(heights, pacific, Integer.MIN_VALUE, i, 0);
            dfs(heights, atlantic, Integer.MIN_VALUE, i, col - 1);
        }
        for (int i = 0; i < col; i++) {
            dfs(heights, pacific, Integer.MIN_VALUE, 0, i);
            dfs(heights, atlantic, Integer.MIN_VALUE, row - 1, i);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private void dfs(int[][] heights, boolean[][] ocean, int height, int x, int y) {
        int n = heights.length;
        int m = heights[0].length;
        if (x < 0 || x >= n || y < 0 || y >= m || ocean[x][y] || heights[x][y] < height) {
            return;
        }
        ocean[x][y] = true;
        for (int[] dir : dirs) {
            dfs(heights, ocean, heights[x][y], x + dir[0], dir[1]);
        }
    }
}
