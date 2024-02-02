package main.java.com.leetcode._1857;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LargestColorValueInaDirectedGraph {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[n];
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            indegree[edge[1]]++;
        }
        int[][] count = new int[n][26];
        boolean[] visit = new boolean[n];
        boolean[] inStack = new boolean[n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dfs(i, colors, adj, count, visit, inStack));
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private int dfs(int node, String colors, Map<Integer, List<Integer>> adj, int[][] count, boolean[] visit, boolean[] inStack) {
        if (inStack[node]) {
            return Integer.MAX_VALUE;
        }
        if (visit[node]) {
            return count[node][colors.charAt(node) - 'a'];
        }
        visit[node] = true;
        inStack[node] = true;
        if(adj.containsKey(node)){
            for (Integer neighbor : adj.get(node)) {
                if(dfs(neighbor, colors, adj, count, visit, inStack) == Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }
                for (int i = 0; i < 26; i++) {
                    count[node][i] = Math.max(count[node][i], count[neighbor][i]);
                }
            }
        }
        count[node][colors.charAt(node)-'a']++;
        inStack[node] = false;
        return count[node][colors.charAt(node)-'a'];
    }

    public static void main(String[] args) {
        LargestColorValueInaDirectedGraph l = new LargestColorValueInaDirectedGraph();
        System.out.println(l.largestPathValue(
                "abaca",
                new int[][]{{0, 1}, {0, 2}, {2, 3}, {3, 4}}
        ));//Output: 3
        System.out.println(l.largestPathValue(
                "a",
                new int[][]{{0, 0}}
        ));//Output: -1
    }
}
