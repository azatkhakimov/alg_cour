package leetcode._2421;

import java.util.*;

public class    NumberOfGoodPaths {

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            adj.computeIfAbsent(a, value -> new ArrayList<>()).add(b);
            adj.computeIfAbsent(b, value -> new ArrayList<>()).add(a);
        }

        int n = vals.length;
        TreeMap<Integer, List<Integer>> valuesToNodes = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            valuesToNodes.computeIfAbsent(vals[i], value -> new ArrayList<>()).add(i);
        }
        UnionFind dsu = new UnionFind(n);
        int goodPaths = 0;

        for (Integer value : valuesToNodes.keySet()) {
            for (Integer node : valuesToNodes.get(value)) {
                if(!adj.containsKey(node)){
                    continue;
                }
                for (Integer neighbor : adj.get(node)) {
                    if(vals[node] >= vals[neighbor]){
                        dsu.setUnion(node, neighbor);
                    }
                }
            }

            Map<Integer, Integer> group = new HashMap<>();
            for (Integer u : valuesToNodes.get(value)) {
                group.put(dsu.find(u), group.getOrDefault(dsu.find(u), 0)+1);
            }
            for (Integer key : group.keySet()) {
                int size = group.get(key);
                goodPaths += size*(size+1)/2;
            }
        }
        return goodPaths;
    }

    public static void main(String[] args) {
        NumberOfGoodPaths paths = new NumberOfGoodPaths();
        System.out.println(paths.numberOfGoodPaths(
                new int[]{1, 3, 2, 1, 3},
                new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}}
        ));//Output: 6
        System.out.println(paths.numberOfGoodPaths(
                new int[]{1, 1, 2, 2, 3},
                new int[][]{{0, 1}, {1, 2}, {2, 3}, {2, 4}}
        ));//Output: 7
        System.out.println(paths.numberOfGoodPaths(
                new int[]{1},
                new int[][]{}
        ));//Output: 1
    }
}
