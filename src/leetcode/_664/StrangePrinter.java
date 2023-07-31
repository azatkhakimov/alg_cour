package leetcode._664;

public class StrangePrinter {

    public int strangePrinter(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int length = 1; length <= n; length++) {
            for (int left = 0; left <= n-length; left++) {
                int right = left+length-1;
                int j = -1;
                dp[left][right] = n;
                for (int i = left; i < right; i++) {
                    if(s.charAt(i) != s.charAt(right) && j == -1){
                        j = i;
                    }
                    if(j != -1){
                        dp[left][right] = Math.min(dp[left][right], 1+dp[j][i]+dp[i+1][right]);
                    }
                }
                if(j == -1){
                    dp[left][right] = 0;
                }

            }
        }
        return dp[0][n-1]+1;
    }


    public static void main(String[] args) {
        var s = new StrangePrinter();
        System.out.println(s.strangePrinter("aaabbb"));//Output: 2
        System.out.println(s.strangePrinter( "aba"));//Output: 2
    }
}
