package leetcode._2050;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParallelCoursesIII {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    Map<Integer, Integer> memo = new HashMap<>();

    public int minimumTime(int n, int[][] relations, int[] time) {
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge : relations) {
            int x = edge[0] - 1;
            int y = edge[1] - 1;
            graph.get(x).add(y);
        }

        int ans = 0;
        for (int node = 0; node < n; node++) {
            ans = Math.max(ans, dfs(node, time));
        }

        return ans;
    }

    private int dfs(int node, int[] time) {
        if (memo.containsKey(node)) {
            return memo.get(node);
        }

        if(graph.get(node).isEmpty()){
            return time[node];
        }
        int ans = 0;
        for (Integer neighbor : graph.get(node)) {
            ans = Math.max(ans, dfs(neighbor, time));
        }
        memo.put(node, time[node] + ans);
        return time[node] + ans;
    }

    public static void main(String[] args) {
        var p = new ParallelCoursesIII();
        System.out.println(p.minimumTime(3, new int[][]{{1,3}, {2,3}}, new int[]{3,2,5}));//Output: 8
        System.out.println(p.minimumTime(5, new int[][]{{1,5}, {2,5}, {3,5}, {3,4}, {4,5}}, new int[]{1,2,3,4,5}));//Output: 12
    }
}
