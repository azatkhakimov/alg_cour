package leetcode._1129;

import java.util.*;

public class ShortestPathWithAlternatingColors {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Map<Integer, List<List<Integer>>> adj = new HashMap<>();
        for (int[] redEdge : redEdges) {
            adj.computeIfAbsent(redEdge[0], k -> new ArrayList<>()).add(Arrays.asList(redEdge[1], 0));
        }
        for (int[] blueEdge : blueEdges) {
            adj.computeIfAbsent(blueEdge[0], k -> new ArrayList<>()).add(Arrays.asList(blueEdge[1], 1));
        }

        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        boolean[][] visit = new boolean[n][2];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, -1});
        answer[0] = 0;
        visit[0][1] = visit[0][0] = true;

        while (!q.isEmpty()) {
            int[] element = q.poll();
            int node = element[0];
            int steps = element[1];
            int prevColor = element[2];

            if (!adj.containsKey(node)) {
                continue;
            }
            for (List<Integer> nei : adj.get(node)) {
                int neighbor = nei.get(0);
                int color = nei.get(1);
                if (!visit[neighbor][color] && color != prevColor) {
                    if (answer[neighbor] == -1) {
                        answer[neighbor] = 1 + steps;
                    }
                    visit[neighbor][color] = true;
                    q.offer(new int[]{neighbor, 1 + steps, color});
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        ShortestPathWithAlternatingColors s = new ShortestPathWithAlternatingColors();
        System.out.println(Arrays.toString(s.shortestAlternatingPaths(
                3,
                new int[][]{{0, 1}, {1, 2}},
                new int[][]{}
        )));//Output: [0,1,-1]
        System.out.println(Arrays.toString(s.shortestAlternatingPaths(
                3,
                new int[][]{{0, 1}},
                new int[][]{{2, 1}}
        )));//Output: [0,1,-1]
    }
}
