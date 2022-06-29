package leetcode.array._1354;

import java.util.Collections;
import java.util.PriorityQueue;

public class ConstructTargetArrayWithMultipleSums {
    public boolean isPossible(int[] target) {
        if (target.length == 1) {
            return target[0] == 1;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;
        for (int t : target) {
            pq.add(t);
            sum += t;
        }

        while (pq.peek() != 1) {
            int current = pq.poll();
            if(sum - current == 1){
                return true;
            }
            int x = current % (sum - current);
            sum = sum-current+x;

            if (x == 0 || x == current) {
                return false;
            } else {
                pq.add(x);
            }
        }
        return true;

    }

    public static void main(String[] args) {
        ConstructTargetArrayWithMultipleSums test = new ConstructTargetArrayWithMultipleSums();
        System.out.println(test.isPossible(new int[]{9, 3, 5}));//true
    }
}
