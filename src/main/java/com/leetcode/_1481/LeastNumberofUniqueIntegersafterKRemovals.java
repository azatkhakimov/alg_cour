package main.java.com.leetcode._1481;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LeastNumberofUniqueIntegersafterKRemovals {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0)+1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(freq.values());
        int removedEl = 0;
        while (!minHeap.isEmpty()) {
            removedEl += minHeap.peek();
            if(removedEl > k){
                return minHeap.size();
            }
            minHeap.poll();
        }
        return 0;
    }

    public static void main(String[] args) {
        var l = new LeastNumberofUniqueIntegersafterKRemovals();
        System.out.println(l.findLeastNumOfUniqueInts(new int[]{5, 5, 4}, 1));//Output: 1
        System.out.println(l.findLeastNumOfUniqueInts(new int[]{4, 3, 1, 1, 3, 3, 2}, 3));//Output: 2
    }
}
