package leetcode._1962;

import java.util.PriorityQueue;

public class RemoveStonesToMinimizeTheTotal {

    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b)->b-a);
        for (int pile : piles) {
            heap.add(pile);
        }

        for (int i = 0; i < k; i++) {
            int cur = heap.remove();
            int remove = cur/2;
            heap.add(cur-remove);
        }
        int ans = 0;
        for (Integer num : heap) {
            ans += num;
        }
        return ans;
    }

    public static void main(String[] args) {
        RemoveStonesToMinimizeTheTotal stones = new RemoveStonesToMinimizeTheTotal();
        System.out.println(stones.minStoneSum(new int[]{5,4,9}, 2));//Output: 12
        System.out.println(stones.minStoneSum(new int[]{4,3,6,7}, 3));//Output: 12
    }
}
