package main.java.com.leetcode._1416;

public class RestoreTheArray {

    public int numberOfArrays(String s, int k) {
        int m = s.length();
        int mod = 1_000_000_007;
        int[] dp = new int[m + 1];
        dp[0] = 1;
        for (int start = 0; start < m; start++) {
            if (s.charAt(start) == '0') {
                continue;
            }
            for (int end = start; end < m; end++) {
                String currNumber = s.substring(start, end + 1);
                if (Long.parseLong(currNumber) > k) {
                    break;
                }
                dp[end+1] = (dp[end+1] + dp[start]) % mod;
            }
        }
        return dp[m];
    }

    public static void main(String[] args) {
        RestoreTheArray r = new RestoreTheArray();
        System.out.println(r.numberOfArrays("1000",  10000));//Output: 1
        System.out.println(r.numberOfArrays("1000",  10));//Output: 0
        System.out.println(r.numberOfArrays("1317",  2000));//Output: 8
    }
}
