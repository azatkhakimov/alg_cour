package main.java.com.leetcode._1706;

import java.util.Arrays;

public class WhereWillTheBallFall {
    public int[] findBall(int[][] grid) {
        int[] res = new int[grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            res[i] = findBallDropCol(0, i, grid);
        }
        return res;
    }

    private int findBallDropCol(int row, int col, int[][] grid) {
        if(row == grid.length){
            return col;
        }
        int nextCol = col + grid[row][col];
        if(nextCol < 0 || nextCol > grid[0].length-1 || grid[row][col] != grid[row][nextCol]){
            return -1;
        }
        return findBallDropCol(row+1, nextCol, grid);
    }

    public static void main(String[] args) {
        WhereWillTheBallFall whereWillTheBallFall = new WhereWillTheBallFall();
        System.out.println(Arrays.toString(whereWillTheBallFall.findBall(new int[][]{
                {1, 1, 1, -1, -1},
                {1, 1, 1, -1, -1},
                {-1, -1, -1, 1, 1},
                {1, 1, 1, 1, -1},
                {-1, -1, -1, -1, -1}
        })));//Output: [1,-1,-1,-1,-1]

        System.out.println(Arrays.toString(whereWillTheBallFall.findBall(new int[][]{
                {-1}
        })));//Output: [-1]

        System.out.println(Arrays.toString(whereWillTheBallFall.findBall(new int[][]{
                {1, 1, 1, 1, 1, 1},
                {-1, -1, -1, -1, -1, -1},
                {1, 1, 1, 1, 1, 1},
                {-1, -1, -1, -1, -1, -1},
        })));//Output: [0,1,2,3,4,-1]
    }
}
