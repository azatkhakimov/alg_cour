package leetcode._373;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return res;
        }
        for (int i = 0; i < nums1.length && i < k; i++) {
            pq.offer(new int[]{nums1[i], nums2[0], 0});
        }
        while (k-- > 0 && !pq.isEmpty()) {
            int[] cur = pq.poll();
            res.add(Arrays.asList(cur[0], cur[1]));
            if (cur[2] == nums2.length - 1) {
                continue;
            }
            pq.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
        }
        return res;
    }

//    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//        PriorityQueue<int[]> que = new PriorityQueue<>((a,b)->a[0]+a[1]-b[0]-b[1]);
//        List<List<Integer>> res = new ArrayList<>();
//        if(nums1.length==0 || nums2.length==0 || k==0) return res;
//        for(int i=0; i<nums1.length && i<k; i++) que.offer(new int[]{nums1[i], nums2[0], 0});
//        while(k-- > 0 && !que.isEmpty()){
//            int[] cur = que.poll();
//            res.add(Arrays.asList(cur[0], cur[1]));
////            res.add(new int[]{cur[0], cur[1]});
//            if(cur[2] == nums2.length-1) continue;
//            que.offer(new int[]{cur[0],nums2[cur[2]+1], cur[2]+1});
//        }
//        return res;
//    }

    public static void main(String[] args) {
        FindKPairsWithSmallestSums finder = new FindKPairsWithSmallestSums();
        System.out.println(finder.kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));//Output: [[1,2],[1,4],[1,6]]
        System.out.println(finder.kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 2));//Output: [[1,1],[1,1]]
        System.out.println(finder.kSmallestPairs(new int[]{1, 2}, new int[]{3}, 3));//Output: [[1,3],[2,3]]
    }
}
