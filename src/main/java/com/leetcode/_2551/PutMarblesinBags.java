package main.java.com.leetcode._2551;

import java.util.Arrays;

public class PutMarblesinBags {


    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        int[] pairWeights = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            pairWeights[i] = weights[i]+weights[i+1];
        }

        Arrays.sort(pairWeights, 0, n-1);
        long answer = 0l;
        for (int i = 0; i < k - 1; i++) {
            answer += pairWeights[n-2-i]-pairWeights[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        var p = new PutMarblesinBags();
        System.out.println(p.putMarbles(new int[]{1, 3, 5, 1}, 2));//Output: 4
        System.out.println(p.putMarbles(new int[]{1, 3}, 2));//Output: 0
    }
}
