package main.java.com.leetcode._1443;

import java.util.*;

public class MinimumTimeToCollectAllApplesInaTree {

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            adj.computeIfAbsent(a, value -> new ArrayList<>()).add(b);
            adj.computeIfAbsent(b, value -> new ArrayList<>()).add(a);
        }
        return dfs(0, -1, adj, hasApple);
    }

    private int dfs(int node, int parent, Map<Integer, List<Integer>> adj, List<Boolean> hasApple) {
        if (!adj.containsKey(node)) {
            return 0;
        }
        int totalTime = 0;
        int childTime = 0;
        for (Integer child : adj.get(node)) {
            if (child == parent) {
                continue;
            }
            childTime = dfs(child, node, adj, hasApple);
            if (childTime > 0 || hasApple.get(child)) {
                totalTime += childTime + 2;
            }

        }
        return totalTime;
    }

    public static void main(String[] args) {
        MinimumTimeToCollectAllApplesInaTree tree = new MinimumTimeToCollectAllApplesInaTree();
        System.out.println(tree.minTime(
                7,
                new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}},
                Arrays.asList(false, false, true, false, true, true, false)));//Output: 8
        System.out.println(tree.minTime(
                7,
                new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}},
                List.of(false, false, true, false, false, true, false)
        ));//Output: 0
    }
}
