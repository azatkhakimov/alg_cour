package main.java.com.leetcode._1035;

public class UncrossedLines {

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[][] dp = new int[n1+1][n2+1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++){
                if(nums1[i-1] == nums2[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[n1][n2];
    }

    public static void main(String[] args) {
        var u = new UncrossedLines();
        System.out.println(u.maxUncrossedLines(
                new int[]{1, 4, 2},
                new int[]{1, 2, 4}
        ));//Output: 2
        System.out.println(u.maxUncrossedLines(
                new int[]{2, 5, 1, 2, 5},
                new int[]{10, 5, 2, 1, 5, 2}
        ));//Output: 3
        System.out.println(u.maxUncrossedLines(
                new int[]{1, 3, 7, 1, 7, 5},
                new int[]{1, 9, 2, 5, 1}
        ));//Output: 2
    }
}
