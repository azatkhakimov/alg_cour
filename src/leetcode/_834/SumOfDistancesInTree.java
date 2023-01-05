package leetcode._834;

import java.util.*;

public class SumOfDistancesInTree {
    int[] ans;
    int[] count;
    List<Set<Integer>> graph;
    int N;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        N = n;
        graph = new ArrayList<>();
        ans = new int[n];
        count = new int[n];
        Arrays.fill(count, 1);

        for (int i = 0; i < n; i++) {
            graph.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        dfs(0,-1);
        dfs2(0, -1);
        return ans;
    }

    private void dfs(int node, int parent) {
        for (Integer child : graph.get(node)) {
            if(child != parent){
                dfs(child, node);
                count[node] += count[child];
                ans[node] += ans[child] + count[child];
            }
        }
    }

    private void dfs2(int node, int parent) {
        for (Integer child : graph.get(node)) {
            if(child != parent){
                ans[child] = ans[node] - count[child] + N - count[child];
                dfs2(child, node);
            }
        }
    }
    

    public static void main(String[] args) {
        SumOfDistancesInTree tree = new SumOfDistancesInTree();
        System.out.println(Arrays.toString(
                tree.sumOfDistancesInTree(6, new int[][]{{0,1},{0,2},{2,3},{2,4},{2,5}})
        ));//Output: [8,12,6,10,10,10]

        System.out.println(Arrays.toString(
                tree.sumOfDistancesInTree(1, new int[][]{})
        ));//Output: [0]

        System.out.println(Arrays.toString(
                tree.sumOfDistancesInTree(2, new int[][]{{1,0}})
        ));//Output: [1,1]
    }
}
