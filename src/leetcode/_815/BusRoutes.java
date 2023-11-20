package leetcode._815;

import java.util.*;

public class BusRoutes {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target){
            return 0;
        }

        HashMap<Integer, List<Integer>> adjList = new HashMap<>();

        for (int r = 0; r < routes.length; r++) {
            for (int stop : routes[r]) {
                List<Integer> route = adjList.getOrDefault(stop, new ArrayList<>());
                route.add(r);
                adjList.put(stop, route);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> vis = new HashSet<>(routes.length);
        for (Integer route : adjList.get(source)) {
            queue.add(route);
            vis.add(route);
        }

        int busCount = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Integer route = queue.remove();
                for (int stop : routes[route]) {
                    if(stop == target){
                        return busCount;
                    }
                    for (Integer nextRoute : adjList.get(stop)) {
                        if(!vis.contains(nextRoute)){
                            vis.add(nextRoute);
                            queue.add(nextRoute);
                        }
                    }
                }
            }
            busCount++;
        }
        return -1;
    }

    public static void main(String[] args) {
        var b = new BusRoutes();
        System.out.println(b.numBusesToDestination(new int[][]{{1, 2, 7}, {3, 6, 7}}, 1, 6));//Output: 2
        System.out.println(b.numBusesToDestination(new int[][]{{7, 12}, {4, 5, 15}, {6}, {15, 19}, {9, 12, 13}}, 15, 12));//Output: -1
    }
}
