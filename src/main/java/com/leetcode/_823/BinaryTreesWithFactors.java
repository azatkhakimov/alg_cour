package main.java.com.leetcode._823;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/binary-trees-with-factors/solution/
public class BinaryTreesWithFactors {
    public int numFactoredBinaryTrees(int[] arr) {
        int MOD = 1_000_000_007;
        int N = arr.length;
        Arrays.sort(arr);
        long[] dp = new long[N];
        Arrays.fill(dp, 1);

        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < N; i++) {
            index.put(arr[i], i);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i] % arr[j] == 0){
                    int right = arr[i]/arr[j];
                    if (index.containsKey(right)){
                        dp[i] = (dp[i]+dp[j]*dp[index.get(right)]) % MOD;
                    }
                }
            }
        }
        long ans = 0;
        for (long l : dp) {
            ans += l;
        }
        return (int)(ans%MOD);
    }

    public static void main(String[] args) {
        BinaryTreesWithFactors binaryTreesWithFactors = new BinaryTreesWithFactors();
        System.out.println(binaryTreesWithFactors.numFactoredBinaryTrees(new int[]{2,4}));//Output: 3
        System.out.println(binaryTreesWithFactors.numFactoredBinaryTrees(new int[]{2,4,5,10}));//Output: 7
    }
}
