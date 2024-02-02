package main.java.com.leetcode._1091;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathinBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1){
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,1});
        grid[0][0] = 1;//initiale set first point as visited
        int[][] dirs = {
                {0,1}, // row and column horizontal right
                {1,0}, //vertical up
                {0,-1}, //horizontal left
                {-1,0}, //vertical down
                {1,1}, //diagonally down left
                {-1, 1}, //diagonally up left
                {1, -1}, //diagonally down right
                {-1, -1}, //diagonally up right
        };
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            if(point[0] == m-1 && point[1] == n-1){
                return point[2];
            }
            for (int[] dir : dirs) {
                int row = point[0] + dir[0];
                int col = point[1] + dir[1];
                if(row >= 0 && col >=0 && row < m && col < n && grid[row][col] == 0){//condition to check that we can visit this point
                    queue.add(new int[]{row, col, point[2]+1});
                    grid[row][col] = 1;//mark as visited
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        var s = new ShortestPathinBinaryMatrix();
        System.out.println(s.shortestPathBinaryMatrix(new int[][]{
                {0,1},
                {1,0}
        }));//Output: 2
        System.out.println(s.shortestPathBinaryMatrix(new int[][]{
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 0}
        }));//Output: 4
        System.out.println(s.shortestPathBinaryMatrix(new int[][]{
                {1,0,0},
                {1,1,0},
                {1,1,0}
        }));//Output: -1
    }
}
