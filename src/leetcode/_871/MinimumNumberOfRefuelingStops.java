package leetcode._871;

public class MinimumNumberOfRefuelingStops {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int N = stations.length;
        long[] dp = new long[N+1];
        dp[0]  = startFuel;
        for (int i = 0; i < N; i++) {
            for (int t = i; t >= 0; t--) {
                if(dp[t] >= stations[i][0]){
                    dp[t+1] = Math.max(dp[t+1], dp[t]+(long)stations[i][1]);
                }
            }
        }
        for(int i = 0; i<=N; i++){
             if(dp[i] >= target){
                 return i;
             }
        }
        return -1;
    }

    public static void main(String[] args) {
        MinimumNumberOfRefuelingStops minimumNumberOfRefuelingStops = new MinimumNumberOfRefuelingStops();
        System.out.println(minimumNumberOfRefuelingStops.minRefuelStops(1, 1, new int[][]{}));//Output: 0
        System.out.println(minimumNumberOfRefuelingStops.minRefuelStops(100, 1, new int[][]{{10, 100}}));//Output: -1
        System.out.println(minimumNumberOfRefuelingStops.minRefuelStops(100, 10,
                new int[][]{{10,60},{20,30},{30,30},{60,40}}));//Output: 2
    }
}
