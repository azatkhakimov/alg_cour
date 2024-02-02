package main.java.com.leetcode._847;

import java.util.*;

public class ShortestPathVisitingAllNodes {

    public int shortestPathLength(int[][] graph) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        int n = graph.length;

        for (int i = 0; i < n; i++) {
            if(!map.containsKey(i)){
                map.put(i, new ArrayList<>());
            }
            int m = graph[i].length;
            for (int j = 0; j < m; j++) {
                map.get(i).add(graph[i][j]);
            }
        }

        int row = (int)Math.pow(2, n);
        int col = n;
        int[][] dist = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(dist[i], -1);
        }

        LinkedList<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int lead = i;
            int mask = setBit(0, i);

            q.add(new int[]{lead, mask});
            dist[mask][lead] = 0;
        }

        while (q.size() > 0){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] path = q.remove();
                int lead = path[0];
                int mask = path[1];

                if(mask == row-1){
                    return dist[mask][lead];
                }

                if(map.containsKey(lead)){
                    for (Integer child : map.get(lead)) {
                        int newLead = child;
                        int newMask = setBit(mask, newLead);

                        if(dist[newMask][newLead] != -1){
                            continue;
                        }
                        dist[newMask][newLead] = dist[mask][lead] + 1;
                        q.add(new int[]{newLead, newMask});
                    }
                }
            }
        }
        return -1;
    }

    private int setBit(int mask, int i) {
        return mask | (1 << i);
    }

    public static void main(String[] args) {
        var s = new ShortestPathVisitingAllNodes();
        System.out.println(s.shortestPathLength(new int[][]{{1,2,3},{0},{0},{0}}));//Output: 4
        System.out.println(s.shortestPathLength(new int[][]{{1},{0,2,4},{1,3,4},{2},{1,2}}));//Output: 4
    }
}
