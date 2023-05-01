package leetcode._879;

public class ProfitableSchemes {
    int mod = 1000000007;
    int[][][] dp = new int[101][101][101];
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profits) {
        for (int count = 0; count <= n; count++) {
            dp[group.length][count][minProfit] = 1;
        }
        for(int index = group.length-1; index>=0; index--){
            for (int count = 0; count <= n; count++) {
                for (int profit = 0; profit <= minProfit; profit++) {
                    dp[index][count][profit] = dp[index+1][count][profit];
                    if(count + group[index] <= n){
                        dp[index][count][profit]
                                = (dp[index][count][profit] + dp[index + 1][count
                                + group[index]][Math.min(minProfit, profit + profits[index])]) % mod;
                    }
                }
            }
        }
        return dp[0][0][0];
    }


    public static void main(String[] args) {
        ProfitableSchemes p = new ProfitableSchemes();
        System.out.println(p.profitableSchemes(5, 3, new int[] {2,2}, new int[] {2,3}));//Output: 2
        System.out.println(p.profitableSchemes(10, 5, new int[] {2,3,5}, new int[] {6,7,8}));//Output: 7
    }
}
