package main.java.com.leetcode.dp._474;

public class OnesAndZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        int [][] dp = new int[m+1][n+1];
        for (String str : strs) {
            int[] count = count(str);
            for (int i = m; i>= count[0]; i--){
                for(int j = n; j>=count[1]; j--){
                    dp[i][j] = Math.max(1+dp[i-count[0]][j-count[1]], dp[i][j]);
                }
            }
        }


        return dp[m][n];
    }

    private int[] count(String str) {
        int[] res = new int[2];
        for(int i = 0; i < str.length(); i++){
            res[str.charAt(i) - '0']++;
        }
        return res;
    }

    public static void main(String[] args) {
        OnesAndZeroes onesAndZeroes = new OnesAndZeroes();
        System.out.println(onesAndZeroes.findMaxForm(new String[]{"10","0001","111001","1","0"}, 5, 3));
    }
}
