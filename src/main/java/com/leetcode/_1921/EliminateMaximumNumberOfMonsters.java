package main.java.com.leetcode._1921;

import java.util.PriorityQueue;

public class EliminateMaximumNumberOfMonsters {

    public int eliminateMaximum(int[] dist, int[] speed) {
        PriorityQueue<Double> heap = new PriorityQueue<>();
        for (int i = 0; i < dist.length; i++) {
            heap.add((double)dist[i]/speed[i]);
        }

        int ans = 0;
        while (!heap.isEmpty()) {
            if(heap.remove() <= ans){
                break;
            }
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        var e = new EliminateMaximumNumberOfMonsters();
        System.out.println(e.eliminateMaximum(new int[]{1, 3, 4}, new int[]{1, 1, 1}));//Output: 3
        System.out.println(e.eliminateMaximum(new int[]{1, 1, 2, 3}, new int[]{1, 1, 1, 1}));//Output: 1
        System.out.println(e.eliminateMaximum(new int[]{3, 2, 4}, new int[]{5, 3, 2}));//Output: 1
    }
}
