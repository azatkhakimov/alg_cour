package main.java.com.leetcode._733;

import java.util.Arrays;

public class FloodFill {
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) {
            return image;
        }
        int oldColor = image[sr][sc];
        image[sr][sc] = color;
        dfs(image, sr, sc, oldColor, color);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int oldColor, int color) {

        int imageLen = image.length;
        int totalCels = image[0].length;
        for (int[] dir : dirs) {
            int row = sr + dir[0];
            int col = sc + dir[1];

            if (row < imageLen && row >= 0 &&  col < totalCels && col >= 0 && image[row][col] == oldColor) {
                image[row][col] = color;
                dfs(image, row, col, oldColor, color);
            }
        }
    }


    public static void main(String[] args) {
        var f = new FloodFill();
        System.out.println(Arrays.deepToString(f.floodFill(new int[][]{
                        {1, 1, 1},
                        {1, 1, 0},
                        {1, 0, 1}},
                1, 1, 2)));//Output: [[2,2,2],[2,2,0],[2,0,1]]

        System.out.println(Arrays.deepToString(f.floodFill(new int[][]{
                        {0, 0, 0},
                        {0, 0, 0}},
                0, 0, 0)));//Output:[[0,0,0],[0,0,0]]
    }
}
