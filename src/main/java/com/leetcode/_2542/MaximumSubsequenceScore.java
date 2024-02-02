package main.java.com.leetcode._2542;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumSubsequenceScore {

    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i] = new int[]{nums1[i], nums2[i]};
        }
        Arrays.sort(pairs, (a, b) -> b[1]-a[1]);
        PriorityQueue<Integer> topKHeap = new PriorityQueue<>(k, Comparator.comparingInt(a -> a));
        long topKSum = 0;
        for (int i = 0; i < k; i++) {
            topKSum += pairs[i][0];
            topKHeap.add(pairs[i][0]);
        }
        long answer = topKSum * pairs[k-1][1];
        for (int i = k; i < n; i++) {
            topKSum += pairs[i][0] - topKHeap.poll();
            topKHeap.add(pairs[i][0]);
            answer = Math.max(answer, topKSum*pairs[i][1]);
        }
        return answer;
    }

    public static void main(String[] args) {
        var m = new MaximumSubsequenceScore();
        System.out.println(
                m.maxScore(new int[]{1,3,3,2}, new int[]{2,1,3,4}, 3)
        );//Output: 12
        System.out.println(
                m.maxScore(new int[]{4,2,3,1,1}, new int[]{7,5,10,9,6}, 1)
        );//Output: 30
    }
}
