package main.java.com.leetcode._1615;

import java.util.*;

public class MaximalNetworkRank {

    public int maximalNetworkRank(int n, int[][] roads) {
        int maxRank = 0;
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for (int[] road : roads) {
            adj.computeIfAbsent(road[0], k-> new HashSet<>()).add(road[1]);
            adj.computeIfAbsent(road[1], k-> new HashSet<>()).add(road[0]);
        }

        for (int node1 = 0; node1 < n; node1++) {
            for (int node2 = node1+1; node2 < n; node2++) {
                int currentRank = adj.getOrDefault(node1, Collections.emptySet()).size()
                        + adj.getOrDefault(node2, Collections.emptySet()).size();

                if(adj.getOrDefault(node1, Collections.emptySet()).contains(node2)){
                    --currentRank;
                }
                maxRank = Math.max(maxRank, currentRank);
            }
        }
        return maxRank;
    }

    public static void main(String[] args) {
        var m = new MaximalNetworkRank();
        System.out.println(m.maximalNetworkRank(4, new int[][]{{0, 1}, {0, 3}, {1, 2}, {1, 3}}));//Output: 4
        System.out.println(m.maximalNetworkRank(5, new int[][]{{0, 1}, {0, 3}, {1, 2}, {1, 3}, {2, 3}, {2, 4}}));//Output: 5
        System.out.println(m.maximalNetworkRank(8, new int[][]{{0, 1}, {1, 2}, {2, 3}, {2, 4}, {5, 6}, {5, 7}}));//Output: 5
    }
}
