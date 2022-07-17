package leetcode.dp._629;

public class KInversePairsArray {
    public int kInversePairs(int n, int k) {
        int[] dp = new int[k+1];
        int MOD = 1000000007;
        for(int i = 1; i <= n; i++){
            int[] temp = new int[k+1];
            temp[0] = 1;
            for(int j = 1; j <= k; j++){
                int val = (dp[j]+MOD-((j-i)>=0 ? dp[j-i] :0)) %MOD;
                temp[j] = (temp[j-1]+val)%MOD;
            }
            dp = temp;
        }
        return ((dp[k]+MOD-(k>0?dp[k-1]:0))%MOD);
    }

    public static void main(String[] args) {
        KInversePairsArray kInversePairsArray = new KInversePairsArray();
        System.out.println(kInversePairsArray.kInversePairs(3,0));//Output: 1
        System.out.println(kInversePairsArray.kInversePairs(3,  1));//Output: 2
    }
}
