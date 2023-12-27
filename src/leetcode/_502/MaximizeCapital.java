package leetcode._502;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximizeCapital {
    public int maximumCapital(int c, int k, int[] capitals, int[] profits) {
        int n = capitals.length;
        int currentCapital = c;
        PriorityQueue<int[]> capitalMinHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < n; i++) {
            capitalMinHeap.offer(new int[]{capitals[i], i});
        }

        PriorityQueue<int[]> profitsMaxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int i = 0;
        while (i < k) {
            while (!capitalMinHeap.isEmpty() && capitalMinHeap.peek()[0] <= currentCapital) {
                int[] j = capitalMinHeap.poll();
                profitsMaxHeap.offer(new int[]{profits[j[1]]});

            }
            if (profitsMaxHeap.isEmpty()) {
                break;
            }
            int x = profitsMaxHeap.poll()[0];
            currentCapital += x;
            i++;
        }
        return currentCapital;
    }

    public static void main(String[] args) {
        MaximizeCapital m = new MaximizeCapital();
        System.out.println(m.maximumCapital(1, 2, new int[]{1, 2, 2, 3}, new int[]{2, 4, 6, 8}));
    }
}
