package main.java.com.leetcode._802;

import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeStates {


    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            for (int node : graph[i]) {
                adj.get(i).add(node);
            }
        }
        boolean[] visit = new boolean[n];
        boolean[] inStack = new boolean[n];
        for (int i = 0; i < n; i++) {
            dfs(i, adj, visit, inStack);
        }
        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(!inStack[i]){
                safeNodes.add(i);
            }
        }
        return safeNodes;
     }

    private boolean dfs(int node, List<List<Integer>> adj, boolean[] visit, boolean[] inStack) {
        if (inStack[node]) {
            return true;
        }
        if(visit[node]){
            return false;
        }

        visit[node] = true;
        inStack[node] = true;
        for (Integer neighbor : adj.get(node)) {
            if(dfs(neighbor, adj, visit, inStack)){
                return true;
            }
        }
        inStack[node] = false;
        return false;
    }

    public static void main(String[] args) {
        var f = new FindEventualSafeStates();
        System.out.println(f.eventualSafeNodes(new int[][]{{1,2},{2,3},{5},{0},{5},{},{}}));//Output: [2,4,5,6]
        System.out.println(f.eventualSafeNodes(new int[][]{{1,2,3,4},{1,2},{3,4},{0,4},{}}));//Output: [4]
    }
}
