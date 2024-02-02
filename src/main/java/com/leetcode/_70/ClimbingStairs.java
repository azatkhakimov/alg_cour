package main.java.com.leetcode._70;

//https://www.youtube.com/watch?v=uHAToNgAPaM
public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }


    public static void main(String[] args) {
        ClimbingStairs stairs = new ClimbingStairs();
        System.out.println(stairs.climbStairs(2));//Output: 2
        System.out.println(stairs.climbStairs(3));//Output: 3
    }
}
