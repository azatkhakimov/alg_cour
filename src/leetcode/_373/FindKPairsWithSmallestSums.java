package leetcode._373;

import java.util.*;

public class FindKPairsWithSmallestSums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> pairs = new ArrayList<>();
        int listLength = nums1.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for(int i = 0; i < Math.min(k ,listLength); i++){
            minHeap.add(new int[]{nums1[i] + nums2[0], i, 0});
        }

        int counter = 1;
        while (!minHeap.isEmpty() && counter <= k) {
            int[] pair = minHeap.poll();
            int i = pair[1];
            int j = pair[2];
            pairs.add(Arrays.asList(nums1[i], nums2[j]));
            int nextElement = j+1;
            if(nums2.length > nextElement){
                minHeap.add(new int[]{nums1[i]+nums2[nextElement], i, nextElement});
            }
            counter++;
        }
        return pairs;
    }


    public static void main(String[] args) {
        FindKPairsWithSmallestSums finder = new FindKPairsWithSmallestSums();
        System.out.println(finder.kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));//Output: [[1,2],[1,4],[1,6]]
        System.out.println(finder.kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 2));//Output: [[1,1],[1,1]]
        System.out.println(finder.kSmallestPairs(new int[]{1, 2}, new int[]{3}, 3));//Output: [[1,3],[2,3]]
    }
}
