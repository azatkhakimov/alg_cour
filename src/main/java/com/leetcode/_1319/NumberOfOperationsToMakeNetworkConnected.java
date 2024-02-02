package main.java.com.leetcode._1319;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfOperationsToMakeNetworkConnected {

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }

        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] connection : connections) {
            adj.computeIfAbsent(connection[0], k -> new ArrayList<>()).add(connection[1]);
            adj.computeIfAbsent(connection[1], k -> new ArrayList<>()).add(connection[0]);
        }

        int numberOfConnectedComponents = 0;
        boolean[] visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                numberOfConnectedComponents++;
                dfs(i, adj, visit);
            }
        }
        return numberOfConnectedComponents - 1;
    }

    private void dfs(int node, Map<Integer, List<Integer>> adj, boolean[] visit) {
        visit[node] = true;
        if(!adj.containsKey(node)){
            return;
        }
        for (Integer neighbor : adj.get(node)) {
            if(!visit[neighbor]){
                visit[neighbor] = true;
                dfs(neighbor, adj, visit);
            }
        }
    }

    public static void main(String[] args) {
        NumberOfOperationsToMakeNetworkConnected n = new NumberOfOperationsToMakeNetworkConnected();
        System.out.println(n.makeConnected(4, new int[][]{{0, 1}, {0, 2}, {1, 2}}));//Output: 1
        System.out.println(n.makeConnected(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}}));//Output: 2
        System.out.println(n.makeConnected(6, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}}));//Output: -1
    }
}
