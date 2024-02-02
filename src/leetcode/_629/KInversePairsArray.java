package leetcode._629;

public class KInversePairsArray {
    public int kInversePairs(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j == 0)
                    dp[i][j] = 1;
                else {
                    for (int p = 0; p <= Math.min(j, i - 1); p++)
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - p]) % 1000000007;
                }
            }
        }
        return dp[n][k];
    }

    public static void main(String[] args) {
        var k = new KInversePairsArray();
        System.out.println(k.kInversePairs( 3, 0));//Output: 1
        System.out.println(k.kInversePairs( 3,  1));//Output: 2
    }
}
