package leetcode._403;

import java.util.HashMap;
import java.util.Map;

public class FrogJump {

    HashMap<Integer,Integer> mark = new HashMap<>();
    boolean [][] dp = new boolean[2001][2001];

    public boolean canCross(int[] stones) {
        int n = stones.length;
        for (int i = 0 ; i < n; i++) {
            mark.put(stones[i], i);
        }

        dp[0][0] = true;
        for (int index = 0; index < n; index++) {
            for (int prevJump = 0; prevJump <= n; prevJump++) {
                if (dp[index][prevJump]) {
                    if (mark.containsKey(stones[index] + prevJump)) {
                        dp[mark.get(stones[index] + prevJump)][prevJump] = true;
                    }
                    if (mark.containsKey(stones[index] + prevJump + 1)) {
                        dp[mark.get(stones[index] + prevJump + 1)][prevJump + 1] = true;
                    }
                    if (mark.containsKey(stones[index] + prevJump - 1)) {
                        dp[mark.get(stones[index] + prevJump - 1)][prevJump - 1] = true;
                    }
                }


            }
        }
        for (int index = 0; index <= n; index++) {
            if (dp[n - 1][index]) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        var f = new FrogJump();
        System.out.println(f.canCross(new int[]{0, 1, 3, 5, 6, 8, 12, 17}));//Output: true
        System.out.println(f.canCross(new int[]{0, 1, 2, 3, 4, 8, 9, 11}));//Output: false
    }
}
