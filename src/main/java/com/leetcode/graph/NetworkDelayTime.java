package main.java.com.leetcode.graph;

import java.util.*;

public class NetworkDelayTime {
    Map<Integer, List<AbstractMap.SimpleImmutableEntry<Integer, Integer>>> adj = new HashMap<>();

    public int networkDelayTime(int[][] times, int n, int k) {
        for (int[] time : times) {
            int source = time[0];
            int dest = time[1];
            int travelTime = time[2];

            adj.putIfAbsent(source, new ArrayList<>());
            adj.get(source).add(new AbstractMap.SimpleImmutableEntry<>(travelTime, dest));
        }

        int[] signalReceivedAt = new int[n + 1];
        Arrays.fill(signalReceivedAt, Integer.MAX_VALUE);
        dijkstra(signalReceivedAt, k, n);


        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, signalReceivedAt[i]);
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;

    }

    private void dijkstra(int[] signalReceivedAt, int source, int n) {
        Queue<AbstractMap.SimpleImmutableEntry<Integer, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByKey());
        pq.add(new AbstractMap.SimpleImmutableEntry<>(0, source));
        signalReceivedAt[source] = 0;

        while (!pq.isEmpty()) {
            AbstractMap.SimpleImmutableEntry<Integer, Integer> topPair = pq.remove();
            int curNode = topPair.getValue();
            int curNodeTime = topPair.getKey();

            if (curNodeTime > signalReceivedAt[curNode]) {
                continue;
            }
            if (!adj.containsKey(curNode)) {
                continue;
            }

            for (AbstractMap.SimpleImmutableEntry<Integer, Integer> edge : adj.get(curNode)) {
                int time = edge.getKey();
                int neighbourNode = edge.getValue();


                if (signalReceivedAt[neighbourNode] > curNodeTime + time) {
                    signalReceivedAt[neighbourNode] = curNodeTime + time;
                    pq.add(new AbstractMap.SimpleImmutableEntry<>(signalReceivedAt[neighbourNode], neighbourNode));
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new NetworkDelayTime().networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2));
    }
}
