package main.java.com.leetcode._1046;

import java.util.Comparator;
import java.util.PriorityQueue;

//https://www.youtube.com/watch?v=fBPS7PtPtaE
public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) {
            pq.add(stone);
        }
        while (!pq.isEmpty()){
            if(pq.size() == 1){
                return pq.poll();
            }
            int stone1  = pq.poll();
            int stone2 = pq.poll();
            if(stone1 != stone2){
                pq.add(stone1-stone2);
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        LastStoneWeight l = new LastStoneWeight();
        System.out.println(l.lastStoneWeight(new int[]{2,7,4,1,8,1}));//Output: 1
        System.out.println(l.lastStoneWeight(new int[]{}));//Output: 1
    }
}
