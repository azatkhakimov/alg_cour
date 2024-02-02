package main.java.com.leetcode._1926;

import java.util.LinkedList;
import java.util.Queue;

public class NearestExitFromEntranceInMaze {
    public int nearestExit(char[][] maze, int[] entrance) {
        int row = maze.length;
        int col = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[row][col];
        int [][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};

        int steps = 0;
        queue.offer(entrance);
        visited[entrance[0]][entrance[1]] = true;
        while (!queue.isEmpty()){
            int queueSize = queue.size();
            steps++;
            for (int i = 0; i < queueSize; i++) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int x = dir[0]+cur[0];
                    int y = dir[1]+cur[1];

                    if(x < 0 || x >= row || y < 0 || y >= col){
                        continue;
                    }
                    if(visited[x][y] || maze[x][y] == '+'){
                        continue;
                    }
                    if(x == 0 || x == row-1 || y == 0 || y == col-1){
                        return steps;
                    }
                    queue.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        NearestExitFromEntranceInMaze exit = new NearestExitFromEntranceInMaze();
        System.out.println(exit.nearestExit(new char[][]
                {
                        {'+', '+', '.', '+'},
                        {'.', '.', '.', '+'},
                        {'+', '+', '+', '.'}
                }, new int[]{1, 2}));//Output: 1
        System.out.println(exit.nearestExit(new char[][]
                {
                        {'+','+','+'},
                        {'.','.','.'},
                        {'+','+','+'}
                }, new int[]{1,0}));//Output: 2
    }
}
