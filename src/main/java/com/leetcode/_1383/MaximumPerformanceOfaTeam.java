package main.java.com.leetcode._1383;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumPerformanceOfaTeam {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] ess = new int[n][2];
        for (int i = 0; i < n; i++) {
            ess[i] = new int[]{efficiency[i], speed[i]};
        }
        Arrays.sort(ess, (a, b) -> b[0] - a[0]);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, Comparator.comparingInt(a -> a));
        long res = 0;
        long sumS = 0;
        for (int[] es : ess) {
            priorityQueue.add(es[1]);
            sumS = (sumS + es[1]);
            if (priorityQueue.size() > k) {
                sumS -= priorityQueue.poll();
            }
            res = Math.max(res, (sumS * es[0]));
        }
        return (int) (res % (long) (1e9 + 7));
    }

    public static void main(String[] args) {
        MaximumPerformanceOfaTeam maximumPerformanceOfaTeam = new MaximumPerformanceOfaTeam();
        System.out.println(maximumPerformanceOfaTeam.maxPerformance(6, new int[]{2, 10, 3, 1, 5, 8},
                new int[]{5, 4, 3, 9, 7, 2}, 2));//Output: 60
        System.out.println(maximumPerformanceOfaTeam.maxPerformance(6, new int[]{2, 10, 3, 1, 5, 8},
                new int[]{5, 4, 3, 9, 7, 2}, 3));//Output: 68
        System.out.println(maximumPerformanceOfaTeam.maxPerformance(6, new int[]{2, 10, 3, 1, 5, 8},
                new int[]{5, 4, 3, 9, 7, 2}, 4));//Output: 72
    }
}
