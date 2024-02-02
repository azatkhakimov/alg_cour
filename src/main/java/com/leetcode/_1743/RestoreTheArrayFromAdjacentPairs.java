package main.java.com.leetcode._1743;

import java.util.*;

public class RestoreTheArrayFromAdjacentPairs {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    public int[] restoreArray(int[][] adjacentPairs) {
        for (int[] edge : adjacentPairs) {
            int x = edge[0];
            int y = edge[1];

            if(!graph.containsKey(x)){
                graph.put(x, new ArrayList<>());
            }

            if(!graph.containsKey(y)){
                graph.put(y, new ArrayList<>());
            }

            graph.get(x).add(y);
            graph.get(y).add(x);

        }
        int root = 0;
        for (Integer num : graph.keySet()) {
            if(graph.get(num).size() == 1){
                root = num;
                break;
            }
        }
        int[] ans = new int[graph.size()];
        dfs(root, Integer.MAX_VALUE, ans, 0);
        return ans;
    }

    private void dfs(int node, int prev, int[] ans, int i) {
        ans[i] = node;
        for (Integer neighbor : graph.get(node)) {
            if(neighbor != prev){
                dfs(neighbor, node, ans, i+1);
            }
        }
    }

    public static void main(String[] args) {
        var r = new RestoreTheArrayFromAdjacentPairs();
        System.out.println(Arrays.toString(r.restoreArray(new int[][]{{2,1},{3,4},{3,2}})));//Output: [1,2,3,4]
        System.out.println(Arrays.toString(r.restoreArray(new int[][]{{4,-2},{1,4},{-3,1}})));//Output: [-2,4,1,-3]
        System.out.println(Arrays.toString(r.restoreArray(new int[][]{{100000,-100000}})));//Output: [100000,-100000]
    }
}
