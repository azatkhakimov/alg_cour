package main.java.com.leetcode._935;

import java.util.Arrays;

public class KnightDiale {

    public int knightDialer(int n) {
        int[][] jumps = new int[][]{
                {4, 6},
                {6, 8},
                {7, 9},
                {4, 8},
                {3, 9, 0},
                {},
                {1, 7, 0},
                {2, 6},
                {1, 3},
                {2, 4}
        };

        int MOD = (int) 1e9+7;
        int[] dp = new int[10];
        int[] prevDp = new int[10];
        Arrays.fill(prevDp, 1);

        for (int remain = 1; remain < n; remain++) {
            dp = new int[10];
            for (int square = 0; square < 10; square++) {
                int ans = 0;
                for (int nextSquare : jumps[square]) {
                    ans = (ans + prevDp[nextSquare]) % MOD;
                }

                dp[square] = ans;
            }
            prevDp = dp;
        }

        int ans = 0;
        for (int sqaure = 0; sqaure < 10; sqaure++) {
            ans = (ans + prevDp[sqaure]) % MOD;
        }
        return ans;
    }


    public static void main(String[] args) {
        var k = new KnightDiale();
        System.out.println(k.knightDialer(1));//Output: 10
        System.out.println(k.knightDialer(2));//Output: 20
        System.out.println(k.knightDialer(3131));//Output: 136006598
    }
}
