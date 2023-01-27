package leetcode._2316;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountUnreachablePairsOfNodesInAnUndirectedGraph {

    public long countPairs(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        long numberOfPairs = 0;
        long sizeOfComponent = 0;
        long remainingNodes = n;
        boolean[] visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            if(!visit[i]){
                sizeOfComponent = dfs(i, adj, visit);
                numberOfPairs += sizeOfComponent * (remainingNodes-sizeOfComponent);
                remainingNodes -= sizeOfComponent;
            }
        }
        return numberOfPairs;
    }

    private int dfs(int node, Map<Integer, List<Integer>> adj, boolean[] visit) {
        int count = 1;
        visit[node] = true;
        if(!adj.containsKey(node)){
            return count;
        }
        for (Integer neighbor : adj.get(node)) {
            if(!visit[neighbor]){
                count += dfs(neighbor, adj, visit);
            }
        }
        return count;
    }


    public static void main(String[] args) {
        CountUnreachablePairsOfNodesInAnUndirectedGraph c = new CountUnreachablePairsOfNodesInAnUndirectedGraph();
        System.out.println(c.countPairs(3, new int[][] {{0,1},{0,2},{1,2}}));//Output: 0
        System.out.println(c.countPairs( 7, new int[][] {{0,2},{0,5},{2,4},{1,6},{5,4}}));//Output: 14
    }
}
