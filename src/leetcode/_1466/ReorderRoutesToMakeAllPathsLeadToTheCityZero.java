package leetcode._1466;

import java.util.*;

public class ReorderRoutesToMakeAllPathsLeadToTheCityZero {
    private int count;

    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<List<Integer>>> adj = new HashMap<>();
        for (int[] connection : connections) {
            adj.computeIfAbsent(connection[0], k -> new ArrayList<>()).add(Arrays.asList(connection[1], 1));
            adj.computeIfAbsent(connection[1], k -> new ArrayList<>()).add(Arrays.asList(connection[0], 0));
        }
        dfs(0, -1, adj);
        return count;
    }

    private void dfs(int node, int parent, Map<Integer, List<List<Integer>>> adj) {
        if(!adj.containsKey(node)){
            return;
        }
        for (List<Integer> nei : adj.get(node)) {
            int child = nei.get(0);
            int sign = nei.get(1);
            if(child != parent){
                count += sign;
                dfs(child, node, adj);
            }
        }
    }

    public static void main(String[] args) {
        ReorderRoutesToMakeAllPathsLeadToTheCityZero r = new ReorderRoutesToMakeAllPathsLeadToTheCityZero();
        System.out.println(r.minReorder(6, new int[][]{{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}}));//Output: 3
        System.out.println(r.minReorder(5, new int[][]{{1, 0}, {1, 2}, {3, 2}, {3, 4}}));//Output: 2
        System.out.println(r.minReorder(3, new int[][]{{1, 0}, {2, 0}}));//Output: 0
    }
}
