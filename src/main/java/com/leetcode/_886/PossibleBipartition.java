package main.java.com.leetcode._886;

import java.util.*;

public class PossibleBipartition {

    public boolean possibleBipartition(int n, int[][] dislikes) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] dislike : dislikes) {
            int a = dislike[0];
            int b = dislike[1];
            adj.computeIfAbsent(a, value-> new ArrayList<>()).add(b);
            adj.computeIfAbsent(b, value -> new ArrayList<>()).add(a);
        }
        int[] color = new int[n+1];
        Arrays.fill(color, -1);
        for (int i = 1; i <= n; i++) {
            if(color[i] == -1){
                if(!dfs(i, 0, adj, color)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int node, int nodeColor, Map<Integer, List<Integer>> adj, int[] color) {
        color[node] = nodeColor;
        if(!adj.containsKey(node)){
            return true;
        }
        for (Integer neighbor : adj.get(node)) {
            if(color[neighbor] == color[node]){
                return false;
            }
            if(color[neighbor] == -1){
                if(!dfs(neighbor, 1 -nodeColor, adj, color)){
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        PossibleBipartition possibleBipartition = new PossibleBipartition();
        System.out.println(possibleBipartition.possibleBipartition(
                4, new int[][]{{1,2},{1,3},{2,4}}
        ));//Output: true

        System.out.println(possibleBipartition.possibleBipartition(
                3, new int[][]{{1,2},{1,3},{2,3}}
        ));//Output: false

        System.out.println(possibleBipartition.possibleBipartition(
                5, new int[][]{{1,2},{2,3},{3,4},{4,5},{1,5}}
        ));//Output: false
    }
}
