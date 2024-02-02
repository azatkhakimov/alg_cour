package main.java.com.leetcode._1293;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathinaGridwithObstaclesElimination {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][][] v = new boolean[m][n][k + 1];
        Queue<int[]> queue = new LinkedList<>();
        int steps = 0;
        queue.offer(new int[]{0, 0, k});
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int[] cur = queue.poll();
                if (cur[0] == m - 1 && cur[1] == n - 1) {
                    return steps;
                }
                for (int[] dir : dirs) {
                    int i = cur[0] + dir[0];
                    int j = cur[1] + dir[1];
                    int obs = cur[2];

                    if (i >= 0 && i < m && j >= 0 && j < n) {
                        if (grid[i][j] == 0 && !v[i][j][obs]) {
                            queue.offer(new int[]{i, j, obs});
                            v[i][j][obs] = true;
                        } else if (grid[i][j] == 1 && obs > 0 && !v[i][j][obs-1]) {
                            queue.offer(new int[]{i,j,obs-1});
                            v[i][j][obs-1] = true;

                        }
                    }
                }

            }
            ++steps;
        }
        return -1;
    }



    public static void main(String[] args) {
        ShortestPathinaGridwithObstaclesElimination path = new ShortestPathinaGridwithObstaclesElimination();
        System.out.println(path.shortestPath(new int[][]{{0, 0, 0},
                        {1, 1, 0},
                        {0, 0, 0},
                        {0, 1, 1},
                        {0, 0, 0}},
                1));//Output: 6
        System.out.println(path.shortestPath(new int[][]{{0, 1, 1},
                        {1, 1, 1},
                        {1, 0, 0}},
                1));//Output: -1
    }
}
