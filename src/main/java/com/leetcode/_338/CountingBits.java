package main.java.com.leetcode._338;

import java.util.Arrays;

public class CountingBits {

    public int[] countBits(int n) {
        int[] answer = new int[n+1];
        for (int i = 0; i <= n; i++) {
            answer[i] = answer[i >> 1] + i%2;
        }
        return answer;
    }

    public static void main(String[] args) {
        CountingBits c = new CountingBits();
        System.out.println(Arrays.toString(c.countBits(2)));//[0,1,1]
        System.out.println(Arrays.toString(c.countBits(5)));//0,1,1,2,1,2
    }
}
