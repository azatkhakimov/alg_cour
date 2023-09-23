package leetcode._1337;

import java.util.Arrays;
import java.util.PriorityQueue;

public class TheKWeakestRowsinaMatrix {


    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0] != b[0] ? b[0]-a[0] : b[1] -a[1]);
        int[] ans = new int[k];
        for (int i = 0; i < mat.length; i++) {
            pq.offer(new int[]{numOnes(mat[i]), i});
            if(pq.size() > k){
                pq.poll();
            }
        }

        while (k > 0){
            ans[--k] = pq.poll()[1];
        }
        return ans;
    }

    private int numOnes(int[] row) {
        int lo = 0;
        int hi = row.length;
        while (lo < hi){
            int mid = lo + (hi-lo)/2;
            if(row[mid] == 1){
                lo = mid+1;
            }
            else {
                hi = mid;
            }
        }
        return lo;
    }


    public static void main(String[] args) {
        var t = new TheKWeakestRowsinaMatrix();
        System.out.println(Arrays.toString(t.kWeakestRows(new int[][]{{1, 1, 0, 0, 0},
                        {1, 1, 1, 1, 0},
                        {1, 0, 0, 0, 0},
                        {1, 1, 0, 0, 0},
                        {1, 1, 1, 1, 1}},
                3)));//Output: [2,0,3]

    }
}
