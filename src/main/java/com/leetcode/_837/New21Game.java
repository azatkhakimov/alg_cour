package main.java.com.leetcode._837;

public class New21Game {

    public double new21Game(int n, int k, int maxPts) {
        double[] dp = new double[n+1];
        dp[0] = 1;
        double s = k > 0 ? 1 : 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = s / maxPts;
            if(i < k){
                s += dp[i];
            }
            if(i-maxPts >= 0 && i-maxPts<k){
                s-=dp[i-maxPts];
            }
        }
        double ans = 0;
        for (int i = k; i <= n; i++) {
            ans += dp[i];
        }
        return ans;
    }


    public static void main(String[] args) {
        var n = new New21Game();
        System.out.println(n.new21Game(10, 1, 10));//Output: 1.00000
        System.out.println(n.new21Game(6, 1, 10));//Output: 0.60000
        System.out.println(n.new21Game(21, 17, 10));//Output: 0.73278
    }
}
