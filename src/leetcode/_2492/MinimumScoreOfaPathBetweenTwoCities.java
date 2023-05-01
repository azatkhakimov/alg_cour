package leetcode._2492;

import java.util.*;

public class MinimumScoreOfaPathBetweenTwoCities {
    public int minScore(int n, int[][] roads) {
        Map<Integer, List<List<Integer>>> adj = new HashMap<>();
        for (int[] road : roads) {
            adj.computeIfAbsent(road[0],
                    k -> new ArrayList<>()).add(Arrays.asList(road[1], road[2]));
            adj.computeIfAbsent(road[1],
                    k -> new ArrayList<>()).add(Arrays.asList(road[0], road[2]));
        }
        return bfs(n, adj);
    }

    public int bfs(int n, Map<Integer, List<List<Integer>>> adj) {
        boolean[] visit = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        int answer = Integer.MAX_VALUE;
        queue.offer(1);
        visit[1] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (!adj.containsKey(node)) {
                continue;
            }
            for (List<Integer> edge : adj.get(node)) {
                answer = Math.min(answer, edge.get(1));
                if (!visit[edge.get(0)]) {
                    visit[edge.get(0)] = true;
                    queue.offer(edge.get(0));
                }
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        MinimumScoreOfaPathBetweenTwoCities m = new MinimumScoreOfaPathBetweenTwoCities();
        System.out.println(m.minScore(4, new int[][]{{1, 2, 9}, {2, 3, 6}, {2, 4, 5}, {1, 4, 7}}));//Output: 5
        System.out.println(m.minScore(4, new int[][]{{1, 2, 2}, {1, 3, 4}, {3, 4, 7}}));//Output: 2
    }
}
