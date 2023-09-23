package leetcode._1631;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {
    int[] dirs = new int[]{0,1,0,-1,0};
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int [][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        minHeap.offer(new int[]{0,0,0});
        dist[0][0] = 0;

        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int d = top[0];
            int r = top[1];
            int c = top[2];
            if(d>dist[r][c]){
                continue;
            }
            if(r == m - 1 && c == n-1){
                return d;
            }
            for (int i = 0; i < 4; i++) {
                int nr = r + dirs[i];
                int nc = c + dirs[i+1];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n){
                    int newDist = Math.max(d, Math.abs(heights[nr][nc]-heights[r][c]));
                    if(dist[nr][nc] > newDist){
                        dist[nr][nc] = newDist;
                        minHeap.offer(new int[]{dist[nr][nc], nr, nc});
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        var p = new PathWithMinimumEffort();
        System.out.println(p.minimumEffortPath(new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}}));//Output: 2
        System.out.println(p.minimumEffortPath(new int[][]{{1, 2, 3}, {3, 8, 4}, {5, 3, 5}}));//Output: 1
        System.out.println(p.minimumEffortPath(new int[][]{{1, 2, 1, 1, 1}, {1, 2, 1, 2, 1},
                {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 1, 1, 2, 1}}));//Output: 0
    }
}
