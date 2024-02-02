package main.java.com.leetcode._1519;

import java.util.*;

public class NumberOfNodesInTheSubTreeWithTheSameLabel {

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            adj.computeIfAbsent(a, value -> new ArrayList<>()).add(b);
            adj.computeIfAbsent(b, value -> new ArrayList<>()).add(a);
        }
        int[] ans = new int[n];
        char[] label = labels.toCharArray();
        dfs(0, -1, adj, label, ans);
        return ans;
    }

    private int[]  dfs(int node, int parent, Map<Integer, List<Integer>> adj, char[] labels, int[] ans) {
        int[] nodeCounts = new int[26];
        nodeCounts[labels[node]-'a'] = 1;

        if(!adj.containsKey(node)){
            return nodeCounts;
        }
        for (int child : adj.get(node)) {
            if(child == parent){
                continue;
            }
            int[] childCounts = dfs(child, node, adj, labels, ans);
            for (int i = 0; i < 26; i++) {
                nodeCounts[i] += childCounts[i];
            }
        }
        ans[node] = nodeCounts[labels[node]-'a'];
        return nodeCounts;
    }

    public static void main(String[] args) {
        NumberOfNodesInTheSubTreeWithTheSameLabel subtree = new NumberOfNodesInTheSubTreeWithTheSameLabel();
        System.out.println(Arrays.toString(
                subtree.countSubTrees(
                        7,
                        new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}},
                        "abaedcd")
        ));//Output: [2,1,1,1,1,1,1]

        System.out.println(Arrays.toString(
                subtree.countSubTrees(
                        4,
                        new int[][]{{0,1},{1,2},{0,3}},
                        "bbbb")
        ));//Output: [4,2,1,1]
    }
}
