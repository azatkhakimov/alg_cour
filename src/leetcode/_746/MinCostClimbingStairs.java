package leetcode._746;

public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if(i < 2){
                dp[i] = cost[i];
            }else {
                dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
            }
        }
        return Math.min(dp[n-1], dp[n-2]);
    }

    public static void main(String[] args) {
        var m = new MinCostClimbingStairs();
        System.out.println(m.minCostClimbingStairs(new int[]{10,15,20}));//Output: 15
        System.out.println(m.minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));//Output: 6
    }
}
