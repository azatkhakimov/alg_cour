package leetcode._1162;

import java.util.LinkedList;
import java.util.Queue;

public class AsFarFromLandAsPossible {
    private int[][] direction = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int maxDistance(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                visited[i][j] = grid[i][j];
                if (grid[i][j] == 1) {
                    q.offer(new int[]{i, j});
                }
            }
        }
        int distance = -1;
        while (!q.isEmpty()) {
            int qSize = q.size();
            while (qSize-- > 0) {
                int[] landCell = q.poll();

                for (int[] dir : direction) {
                    int x = landCell[0] + dir[0];
                    int y = landCell[1] + dir[1];
                    if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length
                            && visited[x][y] == 0) {
                        visited[x][y] = 1;
                        q.offer(new int[]{x, y});
                    }
                }

            }
            distance++;


        }
        return distance == 0 ? -1 : distance;
    }

    public static void main(String[] args) {
        AsFarFromLandAsPossible l = new AsFarFromLandAsPossible();
        System.out.println(l.maxDistance(
                new int[][]{
                        {1, 0, 1},
                        {0, 0, 0},
                        {1, 0, 1}
                }
        ));//Output: 2
        System.out.println(l.maxDistance(
                new int[][]{
                        {1, 0, 0},
                        {0, 0, 0},
                        {0, 0, 0}
                }
        ));
    }
}
