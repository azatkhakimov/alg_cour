package leetcode._646;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class MaximumLengthofPairChain {


    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
        int curr = Integer.MIN_VALUE;
        int ans = 0;
        for (int[] pair : pairs) {
            if (pair[0] > curr) {
                ans++;
                curr = pair[1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        var m = new MaximumLengthofPairChain();
        System.out.println(m.findLongestChain(new int[][]{{1, 2}, {2, 3}, {3, 4}}));//Output: 2
        System.out.println(m.findLongestChain(new int[][]{{1, 2}, {7, 8}, {4, 5}}));//Output: 3
    }
}
