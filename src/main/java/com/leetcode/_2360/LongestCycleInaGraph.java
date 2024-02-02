package main.java.com.leetcode._2360;

import java.util.HashMap;
import java.util.Map;

public class LongestCycleInaGraph {


    private int answer = -1;

    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                Map<Integer, Integer> dist = new HashMap<>();
                dist.put(i, 1);
                dfs(i, edges, dist, visit);
            }
        }
        return answer;
    }

    private void dfs(int node, int[] edges, Map<Integer, Integer> dist, boolean[] visit) {
        visit[node] = true;
        int neighbor = edges[node];

        if (neighbor != -1 && !visit[neighbor]) {
            dist.put(neighbor, dist.get(node) + 1);
            dfs(neighbor, edges, dist, visit);
        } else if (neighbor != -1 && dist.containsKey(neighbor)) {
            answer = Math.max(answer, dist.get(node) - dist.get(neighbor) + 1);
        }
    }

    public static void main(String[] args) {
        LongestCycleInaGraph l = new LongestCycleInaGraph();
        System.out.println(l.longestCycle(new int[]{3, 3, 4, 2, 3}));//Output: 3
        System.out.println(l.longestCycle(new int[]{2, -1, 3, 1}));//Output: -1
    }
}
