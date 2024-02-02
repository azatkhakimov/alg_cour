package main.java.com.leetcode._2477;

import java.util.*;

public class MinimumFuelCostToReportToTheCapital {
    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length+1;
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] degree = new int[n];

        for (int[] road : roads) {
            adj.computeIfAbsent(road[0], k->new ArrayList<>()).add(road[1]);
            adj.computeIfAbsent(road[1], k-> new ArrayList<>()).add(road[0]);
            degree[road[0]]++;
            degree[road[1]]++;
        }
        return bfs(n, adj, degree, seats);
    }

    private long bfs(int n, Map<Integer, List<Integer>> adj, int[] degree, int seats) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < n; i++) {
            if(degree[i] == 1){
                q.offer(i);
            }
        }

        int[] represent = new int[n];
        Arrays.fill(represent, 1);
        long fuel = 0;
        while (!q.isEmpty()){
            int node = q.poll();
            fuel += Math.ceil((double)represent[node]/seats);
            for (Integer neighbor : adj.get(node)) {
                degree[neighbor]--;
                represent[neighbor] += represent[node];
                if(degree[neighbor] == 1 && neighbor != 0){
                    q.offer(neighbor);
                }
            }
        }
        return fuel;
    }

    public static void main(String[] args) {
        MinimumFuelCostToReportToTheCapital m = new MinimumFuelCostToReportToTheCapital();
        System.out.println(m.minimumFuelCost(
                new int[][]{{0,1},{0,2},{0,3}},
                5
        ));//Output: 3
        System.out.println(m.minimumFuelCost(
                new int[][]{{3,1},{3,2},{1,0},{0,4},{0,5},{4,6}},
                2
        ));//Output: 7
    }
}
