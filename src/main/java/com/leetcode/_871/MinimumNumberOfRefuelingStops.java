package main.java.com.leetcode._871;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumNumberOfRefuelingStops {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if(startFuel >= target){
            return 0;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        int i = 0;
        int n = stations.length;
        int stops = 0;
        int maxDistance = startFuel;
        while (maxDistance < target){
            if(i < n && stations[i][0] <= maxDistance){
                maxHeap.offer(stations[i][1]);
                i++;
            } else if (maxHeap.isEmpty()) {
                return -1;
            }else {
                maxDistance += maxHeap.poll();
                stops++;
            }
        }
        return stops;

    }

    public static void main(String[] args) {
        MinimumNumberOfRefuelingStops minimumNumberOfRefuelingStops = new MinimumNumberOfRefuelingStops();
        System.out.println(minimumNumberOfRefuelingStops.minRefuelStops(1, 1, new int[][]{}));//Output: 0
        System.out.println(minimumNumberOfRefuelingStops.minRefuelStops(100, 1, new int[][]{{10, 100}}));//Output: -1
        System.out.println(minimumNumberOfRefuelingStops.minRefuelStops(100, 10,
                new int[][]{{10,60},{20,30},{30,30},{60,40}}));//Output: 2
    }
}
