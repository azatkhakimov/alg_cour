package main.java.com.leetcode._1584;

import java.util.HashSet;
import java.util.Set;

public class MinCosttoConnectAllPoints {


    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int ans = 0;
        Set<Integer> mst = new HashSet<>();
        mst.add(0);
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = findDist(points, 0, i);
        }
        while (mst.size() != n) {
            int next = -1;
            for (int i = 0; i < n; i++) {
                if (mst.contains(i)) {
                    continue;
                }
                if (next == -1 || dist[next] > dist[i]) {
                    next = i;
                }
            }
            mst.add(next);
            ans += dist[next];
            for (int i = 0; i < n; i++) {
                if (!mst.contains(i)) {
                    dist[i] = Math.min(dist[i], findDist(points, i, next));
                }
            }
        }
        return ans;
    }

    private int findDist(int[][] points, int a, int b) {
        return Math.abs(points[a][0] - points[b][0]) + Math.abs(points[a][1] - points[b][1]);
    }

    public static void main(String[] args) {
        var m = new MinCosttoConnectAllPoints();
        System.out.println(m.minCostConnectPoints(new int[][]{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}}));//Output: 20
        System.out.println(m.minCostConnectPoints(new int[][]{{3, 12}, {-2, 5}, {-4, 1}}));//Output: 18
    }
}
