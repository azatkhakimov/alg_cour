package leetcode.recursive.memorization;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {
    Map<Integer, Integer> cache = new HashMap<>();

    public int climbStairs(int n) {
        cache.put(1, 1);
        cache.put(2, 2);
        return climb(n);
    }

    private int climb(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        cache.put(n, climb(n - 1) + climb(n - 2));
        return cache.get(n);
    }

    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        System.out.println(climbingStairs.climbStairs(3));
    }
}
