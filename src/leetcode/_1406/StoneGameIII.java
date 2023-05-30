package leetcode._1406;

public class StoneGameIII {

    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n+1];
        for (int i = n-1; i >= 0; i--) {
            dp[i] = Integer.MIN_VALUE;
            for(int k = 0, take = 0; k< 3 && i+k<n;k++){
                take+=stoneValue[i+k];
                dp[i] = Math.max(dp[i], take-dp[i+k+1]);
            }
        }
        if(dp[0] > 0){
            return "Alice";
        }
        if(dp[0] < 0){
            return "Bob";
        }
        return "Tie";
    }

    public static void main(String[] args) {
        var s = new StoneGameIII();
        System.out.println(s.stoneGameIII(new int[]{1,2,3,7}));//Output: "Bob"
        System.out.println(s.stoneGameIII(new int[]{1,2,3,-9}));//Output: "Alice"
        System.out.println(s.stoneGameIII(new int[]{1,2,3,6}));//Output: "Tie"
    }
}
