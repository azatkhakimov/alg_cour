package main.java.com.leetcode._215;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if(nums[i] > minHeap.peek()){
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return minHeap.peek();
    }

//    public int findKthLargest(int[] nums, int k) {
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        for(int num : nums){
//            pq.add(num);
//            if(pq.size() > k){
//                pq.remove();
//            }
//        }
//        return pq.remove();
//    }

    public static void main(String[] args) {
        KthLargestElementInAnArray test = new KthLargestElementInAnArray();
        System.out.println(test.findKthLargest(new int[]{3,2,1,5,6,4}, 2));//
    }
}
