package main.java.com.leetcode._2009;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinimumNumberofOperationstoMakeArrayContinuous {

    public int minOperations(int[] nums) {
        int n = nums.length;
        int ans = n;
        Set<Integer> unique = new HashSet<>();
        for (int num : nums) {
            unique.add(num);
        }

        int[] newNums = new int[unique.size()];
        int idx = 0;
        for (Integer num : unique) {
            newNums[idx++] = num;
        }

        Arrays.sort(newNums);

        int j = 0;
        for (int i = 0; i < newNums.length; i++) {
            while (j < newNums.length && newNums[j] < newNums[i]+n){
                j++;
            }

            int count = j - i;
            ans = Math.min(ans, n - count);
        }
        return ans;

    }
    public static void main(String[] args) {
        var m = new MinimumNumberofOperationstoMakeArrayContinuous();
        System.out.println(m.minOperations(new int[]{4,2,5,3}));//Output: 0
        System.out.println(m.minOperations(new int[]{1,2,3,5,6}));//Output: 1
        System.out.println(m.minOperations(new int[]{1,10,100,1000}));//Output: 3
    }
}
