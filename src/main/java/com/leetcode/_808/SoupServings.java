package main.java.com.leetcode._808;

import java.util.HashMap;
import java.util.Map;

public class SoupServings {


    public double soupServings(int n) {
        int m = (int) Math.ceil(n/25.0);
        Map<Integer, Map<Integer, Double>> dp = new HashMap<>();
        dp.put(0, new HashMap<>());
        dp.get(0).put(0, 0.5);
        for (int k = 1; k <= m; k++) {
            dp.put(k, new HashMap<>());
            dp.get(0).put(k, 1.0);
            dp.get(k).put(0, 0.0);
            for (int j = 1; j <= k; j++) {
                dp.get(j).put(k, calculateDp(j, k, dp));
                dp.get(k).put(j, calculateDp(k, j, dp));
            }

            if(dp.get(k).get(k) > 1 - 1e-5){
                return 1;
            }
        }
        return dp.get(m).get(m);
    }

    private double calculateDp(int i, int j, Map<Integer, Map<Integer, Double>> dp) {
        return (dp.get(Math.max(0, i-4)).get(j)
        +dp.get(Math.max(0, i-3)).get(j-1)
        +dp.get(Math.max(0, i-2)).get(Math.max(0, j-2))
        +dp.get(i-1).get(Math.max(0, j-3)))/4;
    }


    public static void main(String[] args) {
        var s = new SoupServings();
        System.out.println(s.soupServings(50));//Output: 0.62500
        System.out.println(s.soupServings(100));//Output: 0.71875
    }
}
