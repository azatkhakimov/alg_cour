package main.java.com.leetcode._542;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(mat[i][j] == 0){
                    queue.offer(new int[]{i,j});
                }else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] dirs = new int[][]{{-1, 0}, {1,0},{0,-1},{0,1}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] d : dirs) {
                int r = cell[0]+d[0];
                int c = cell[1]+d[1];
                if(r<0 || r>=m || c<0 || c>=n || mat[r][c] <= mat[cell[0]][cell[1]]+1){
                    continue;
                }
                queue.add(new int[]{r,c});
                mat[r][c] = mat[cell[0]][cell[1]]+1;

            }
        }
        return mat;
    }


    public static void main(String[] args) {
        Matrix01 m = new Matrix01();
        System.out.println(
                Arrays.deepToString(
                        m.updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}})));//Output: [[0,0,0],[0,1,0],[0,0,0]]
        System.out.println(
                Arrays.deepToString(
                        m.updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}})
                )
        );//Output: [[0,0,0],[0,1,0],[1,2,1]]a
    }
}
