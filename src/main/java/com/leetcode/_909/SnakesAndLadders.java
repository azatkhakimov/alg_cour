package main.java.com.leetcode._909;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadders {


    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Pair<Integer, Integer>[] cells = new Pair[n*n+1];
        int label = 1;
        Integer[] cols = new Integer[n];

        for (int i = 0; i < n; i++) {
            cols[i] = i;
        }

        for (int row = n-1; row >= 0; row--) {
            for (Integer col : cols) {
                cells[label++] = new Pair<>(row, col);
            }
            Collections.reverse(Arrays.asList(cols));
        }

        int[] dist = new int[n*n+1];
        Arrays.fill(dist, -1);
        Queue<Integer> queue = new LinkedList<>();
        dist[1] = 0;
        queue.add(1);
        while (!queue.isEmpty()){
            int cur = queue.remove();
            for(int next = cur + 1; next <= Math.min(cur+6, n*n); next++){
                int row = cells[next].getKey();
                int col = cells[next].getValue();
                int destination = board[row][col] != -1 ? board[row][col] : next;
                if(dist[destination] == -1){
                    dist[destination] = dist[cur] + 1;
                    queue.add(destination);
                }

            }
        }
        return dist[n*n];
    }


    public static void main(String[] args) {
        SnakesAndLadders snakesAndLadders = new SnakesAndLadders();
        System.out.println(snakesAndLadders.snakesAndLadders(new int[][]{
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}
        }));//Output: 4

        System.out.println(snakesAndLadders.snakesAndLadders(new int[][]{
                {-1, -1},
                {-1, 3}
        }));//Output: 1
    }

}
