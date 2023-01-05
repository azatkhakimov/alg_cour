package leetcode._790;

public class DominoAndTrominoTiling {
    public int numTilings(int n) {
        long[] dp = new long[n+3];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 5;
        for (int i = 3; i < n; i++) {
            dp[i] = (dp[i-1]*2+dp[i-3])%1000000007;
        }
        return (int) dp[n-1];
    }

    public static void main(String[] args) {
        DominoAndTrominoTiling domino = new DominoAndTrominoTiling();
        System.out.println(domino.numTilings(3));//Output: 5
        System.out.println(domino.numTilings(1));//Output: 1
    }
}
