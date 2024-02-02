package main.java.com.leetcode._956;

import java.util.HashMap;
import java.util.Map;

public class TallestBillboard {

    public int tallestBillboard(int[] rods) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 0);
        for (int rod : rods) {
            HashMap<Integer, Integer> newDp = new HashMap<>(dp);
            for (Map.Entry<Integer, Integer> entry : dp.entrySet()) {
                Integer diff = entry.getKey();
                Integer taller = entry.getValue();
                int shorter = taller - diff;
                Integer newTaller = newDp.getOrDefault(diff + rod, 0);
                newDp.put(diff+rod, Math.max(newTaller, taller+rod));
                int newDiff = Math.abs(shorter+rod-taller);
                int newTaller2 = Math.max(shorter+rod, taller);
                newDp.put(newDiff, Math.max(newTaller2, newDp.getOrDefault(newDiff, 0)));
            }
            dp = newDp;
        }
        return dp.getOrDefault(0, 0);
    }

    public static void main(String[] args) {
        var t = new TallestBillboard();
        System.out.println(t.tallestBillboard(new int[]{1,2,3,6}));//Output: 6
        System.out.println(t.tallestBillboard(new int[]{1,2,3,4,5,6}));//Output: 10
        System.out.println(t.tallestBillboard(new int[]{1,2}));//Output: 0
    }
}
