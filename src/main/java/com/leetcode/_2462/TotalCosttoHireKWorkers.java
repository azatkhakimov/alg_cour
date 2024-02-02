package main.java.com.leetcode._2462;

import java.util.PriorityQueue;

public class TotalCosttoHireKWorkers {

    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[0] == b[0]){
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });

        for (int i = 0; i < candidates; i++) {
            pq.offer(new int[]{costs[i], 0});
        }
        for (int i = Math.max(candidates, costs.length-candidates); i < costs.length; i++) {
            pq.offer(new int[]{costs[i], 1});
        }
        long answer = 0;
        int nextHead = candidates;
        int nextTail = costs.length-1-candidates;
        for (int i = 0; i < k; i++) {
            int[] curWorker = pq.poll();
            int curCost = curWorker[0];
            int curSectionId = curWorker[1];
            answer+=curCost;

            if(nextHead<=nextTail){
                if(curSectionId == 0){
                    pq.offer(new int[]{costs[nextHead],0});
                    nextHead++;
                }else {
                    pq.offer(new int[]{costs[nextTail], 1});
                    nextTail--;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        var t = new TotalCosttoHireKWorkers();
        System.out.println(t.totalCost(new int[]{17,12,10,2,7,2,11,20,8}, 3, 4));//Output: 11
        System.out.println(t.totalCost(new int[]{1,2,4,1}, 3, 3));//Output: 4

    }
}
