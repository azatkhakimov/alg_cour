package leetcode.sorting._215;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);
            if(minHeap.size() > k){
                minHeap.remove();
            }
        }
        return minHeap.remove();
    }

    public static void main(String[] args) {
        KthLargestElementInAnArray test = new KthLargestElementInAnArray();
        System.out.println(test.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }
}
