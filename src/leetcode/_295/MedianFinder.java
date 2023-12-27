package leetcode._295;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {
    private PriorityQueue<Integer> maxHeapForSmallNumbers;
    private PriorityQueue<Integer> minHeapForLargeNumbers;
    public MedianFinder() {
        maxHeapForSmallNumbers =  new PriorityQueue<>((a,b)->b-a);
        minHeapForLargeNumbers = new PriorityQueue<>(Comparator.comparingInt(a -> a));
    }

    public void addNum(int num) {
        if(maxHeapForSmallNumbers.isEmpty() || maxHeapForSmallNumbers.peek()>= num){
            maxHeapForSmallNumbers.add(num);
        }else {
            minHeapForLargeNumbers.add(num);
        }

        if(maxHeapForSmallNumbers.size() > minHeapForLargeNumbers.size()+1){
            minHeapForLargeNumbers.add(maxHeapForSmallNumbers.poll());
        } else if (minHeapForLargeNumbers.size() > maxHeapForSmallNumbers.size()) {
            maxHeapForSmallNumbers.add(minHeapForLargeNumbers.poll());
        }
    }

    public double findMedian() {
        if(maxHeapForSmallNumbers.size() == minHeapForLargeNumbers.size()){
            return maxHeapForSmallNumbers.peek() /2.0 + minHeapForLargeNumbers.peek() /2.0;
        }
        return maxHeapForSmallNumbers.peek();
    }
}
