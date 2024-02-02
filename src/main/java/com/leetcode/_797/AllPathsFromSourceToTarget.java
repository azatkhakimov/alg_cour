package main.java.com.leetcode._797;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, 0, res, path);

        return res;
    }

    private void dfs(int[][] graph, int node, List<List<Integer>> res, List<Integer> path) {
        if (node == graph.length - 1) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int next : graph[node]) {
            path.add(next);
            dfs(graph, next, res, path);
            path.remove(path.size() - 1);
        }
    }


    public static void main(String[] args) {
        AllPathsFromSourceToTarget target = new AllPathsFromSourceToTarget();
        System.out.println(target.allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}}));//Output: [[0,1,3],[0,2,3]]
        System.out.println(target.allPathsSourceTarget(new int[][]{{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}}));//Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
    }
}
