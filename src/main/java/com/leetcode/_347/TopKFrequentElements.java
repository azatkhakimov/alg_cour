package main.java.com.leetcode._347;

import java.util.*;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(Map.Entry.comparingByValue());

        for (Map.Entry<Integer, Integer> curr : freq.entrySet()) {
            minHeap.offer(curr);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        int[] ans = new int[minHeap.size()];
        for (int i = minHeap.size()-1; i >= 0; i--) {
            ans[i] = minHeap.poll().getKey();
        }
        return ans;
    }

    public static void main(String[] args) {
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        System.out.println(Arrays.toString(topKFrequentElements.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));//1,2
    }
}
