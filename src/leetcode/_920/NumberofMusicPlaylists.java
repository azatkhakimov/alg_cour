package leetcode._920;

public class NumberofMusicPlaylists {
    int MOD = 1_000_000_007;

    public int numMusicPlaylists(int n, int goal, int k) {
        long[][] dp = new long[goal + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= goal; i++) {
            for (int j = 1; j <= Math.min(i,n); j++) {
                dp[i][j] = dp[i-1][j-1]*(n-j+1)%MOD;
                if(j > k){
                    dp[i][j] = (dp[i][j]+dp[i-1][j]*(j-k)%MOD);
                }
            }
        }
        return (int)dp[goal][n];
    }


    public static void main(String[] args) {
        var n = new NumberofMusicPlaylists();
        System.out.println(n.numMusicPlaylists(3,3,1));//Output: 6
        System.out.println(n.numMusicPlaylists(2,3,0));//Output: 6
        System.out.println(n.numMusicPlaylists(2,3,1));//Output: 2
    }
}
