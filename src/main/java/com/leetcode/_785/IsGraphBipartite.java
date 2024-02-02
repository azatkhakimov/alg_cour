package main.java.com.leetcode._785;

import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite {

    public boolean isBipartite(int[][] graph) {
        int length = graph.length;
        int[] colors = new int[length];
        for (int i = 0; i < length; i++) {
            if(colors[i] != 0) {
                continue;
            }
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            colors[i] = 1; //Blue 1; Red -1;
            while (!queue.isEmpty()){
                int curr = queue.poll();
                for (int next : graph[curr]) {
                    if(colors[next] == 0){
                        colors[next] = -colors[curr];
                        queue.offer(next);
                    }else if (colors[next] != -colors[curr]){
                        return false;
                    }               }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        var i = new IsGraphBipartite();
        System.out.println(i.isBipartite(new int[][]{
                {1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}
        }));//Output: false
        System.out.println(i.isBipartite(new int[][]{
                {1, 3}, {0, 2}, {1, 3}, {0, 2}
        }));//Output: true
    }
}
