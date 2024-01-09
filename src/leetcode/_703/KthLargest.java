package leetcode._703;

import java.util.PriorityQueue;

class KthLargest {
    private PriorityQueue<Integer> heap;
    int k = 0;
    public KthLargest(int k, int[] nums) {
        heap = new PriorityQueue<>();
        this.k = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (heap.size() < k) {
            heap.offer(val);
        }else {
            if (val > heap.peek()) {
                heap.poll();
                heap.offer(val);
            }
        }
        return heap.peek();
    }
}
