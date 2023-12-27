package leetcode._480;

import java.util.*;

public class SlidingWindowMedian {
    public double[] medianSlidingWindow(int[] nums, int k) {
        List<Double> medians = new ArrayList<>();
        Map<Integer, Integer> outgoingNum = new HashMap<>();
        PriorityQueue<Integer> smallList = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> largeList = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            smallList.offer(nums[i]);
        }

        for (int i = 0; i < k / 2; i++) {
            largeList.offer(smallList.poll());
        }

        int balance = 0;
        int i = k;

        while (true) {
            if ((k & 1) == 1) {
                medians.add((double) (smallList.peek()));
            } else {
                medians.add((double) ((long) smallList.peek() + (long) largeList.peek()) * 0.5);
            }
            if (i >= nums.length) {
                break;
            }
            int outNum = nums[i - k];
            int inNum = nums[i];
            i++;

            if (outNum <= smallList.peek()) {
                balance -= 1;
            } else {
                balance += 1;
            }

            if (outgoingNum.containsKey(outNum)) {
                outgoingNum.put(outNum, outgoingNum.get(outNum) + 1);
            } else {
                outgoingNum.put(outNum, 1);
            }
            if (smallList.size() > 0 && inNum <= smallList.peek()) {
                balance += 1;
                smallList.offer(inNum);
            } else {
                balance -= 1;
                largeList.offer(inNum);
            }
            if (balance < 0) {
                smallList.offer(largeList.poll());
            } else if (balance > 0) {
                largeList.offer(smallList.poll());

            }
            balance = 0;
            while (smallList.size() > 0 && outgoingNum.containsKey(smallList.peek())
                    && outgoingNum.get(smallList.peek()) > 0) {
                outgoingNum.put(smallList.peek(), outgoingNum.get(smallList.poll()) - 1);
            }
            while (largeList.size() > 0 && outgoingNum.containsKey(largeList.peek())
                    && outgoingNum.get(largeList.peek()) > 0) {
                outgoingNum.put(largeList.peek(), outgoingNum.get(largeList.poll()) - 1);
            }
        }
        double[] arr = medians.stream().mapToDouble(Double::doubleValue).toArray();
        return arr;
    }

    public static void main(String[] args) {
        var s = new SlidingWindowMedian();
        System.out.println(Arrays.toString(s.medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));//Output: [1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000]
        System.out.println(Arrays.toString(s.medianSlidingWindow(new int[]{1, 2, 3, 4, 2, 3, 1, 4, 2}, 3)));//Output: [2.00000,3.00000,3.00000,3.00000,2.00000,3.00000,2.00000]
    }
}
