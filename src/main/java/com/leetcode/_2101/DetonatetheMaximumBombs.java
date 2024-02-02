package main.java.com.leetcode._2101;

import java.util.*;

public class DetonatetheMaximumBombs {

    public int maximumDetonation(int[][] bombs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int n = bombs.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == j){
                    continue;
                }
                int xi = bombs[i][0];
                int yi = bombs[i][1];
                int ri = bombs[i][2];

                int xj = bombs[j][0];
                int yj = bombs[j][1];

                long distance = (long) (xi - xj) *(xi-xj)+ (long) (yi - yj) *(yi-yj);
                long rad = (long) ri * ri;
                if(rad >= distance){
                    graph.computeIfAbsent(i, k -> new ArrayList<>()).add(j); //all neighbours reachable from i
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int count = dfs(i, new HashSet<Integer>(), graph);
            answer = Math.max(answer, count);
        }
        return answer;
    }

    private int dfs(int cur, HashSet<Integer> visited, Map<Integer, List<Integer>> graph) {
        visited.add(cur);
        int count = 1;
        for (Integer neighbour : graph.getOrDefault(cur, new ArrayList<>())) {
            if(!visited.contains(neighbour)){
                count += dfs(neighbour, visited, graph);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        var d = new DetonatetheMaximumBombs();
        System.out.println(d.maximumDetonation(
                new int[][]{{2,1,3},{6,1,4}}
        ));//Output: 2
        System.out.println(d.maximumDetonation(
                new int[][]{{1,1,5},{10,10,5}}
        ));//Output: 1
        System.out.println(d.maximumDetonation(
                new int[][]{{1,2,3},{2,3,1},{3,4,2},{4,5,3},{5,6,4}}
        ));//Output: 5

    }
}
