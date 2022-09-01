package leetcode._417;

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

    private void dfs(int[][] heights, boolean[][] ocean, int height, int i, int j) {
        int row = ocean.length;
        int col = ocean[0].length;
        if (i < 0 || i >= row || j < 0 || j >= col) {
            return;
        }
        if(heights[i][j] < height || ocean[i][j]){
            return;
        }
        ocean[i][j] = true;
        for (int[] dir : dirs) {
            dfs(heights, ocean, heights[i][j], i + dir[0], j+dir[1]);
        }
    }

    public static void main(String[] args) {
        PacificAtlanticWaterFlow pacificAtlanticWaterFlow = new PacificAtlanticWaterFlow();
        int[][] heights = new int[][]{
                {1,2,2,3,5},
                {3,2,3,4,4},
                {2,4,5,3,1},
                {6,7,1,4,5},
                {5,1,1,2,4}
        };
        System.out.println(pacificAtlanticWaterFlow.pacificAtlantic(heights));///Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]].
    }
}
