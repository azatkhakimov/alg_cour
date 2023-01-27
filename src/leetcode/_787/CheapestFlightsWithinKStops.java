package leetcode._787;

import java.util.*;

public class CheapestFlightsWithinKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] flight : flights) {
            adj.computeIfAbsent(flight[0], value -> new ArrayList<>()).add(new int[]{flight[1], flight[2]});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0});
        int stops = 0;
        while (stops <= k && !queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] temp = queue.poll();
                int node = temp[0];
                int distance = temp[1];

                if (!adj.containsKey(node)) {
                    continue;
                }
                for (int[] e : adj.get(node)) {
                    int neighbor = e[0];
                    int price = e[1];
                    if (price + distance >= dist[neighbor]) {
                        continue;
                    }
                    dist[neighbor] = price + distance;
                    queue.offer(new int[]{neighbor, dist[neighbor]});
                }
            }
            stops++;
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];

    }

    public static void main(String[] args) {
        CheapestFlightsWithinKStops stops = new CheapestFlightsWithinKStops();
        System.out.println(stops.findCheapestPrice(4,
                new int[][]{{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}},
                0,
                3,
                1));//Output: 700

        System.out.println(stops.findCheapestPrice(3,
                new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}},
                0,
                2,
                1));//Output: 200

        System.out.println(stops.findCheapestPrice(3,
                new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}},
                0,
                2,
                0));//Output: 500
    }
}
