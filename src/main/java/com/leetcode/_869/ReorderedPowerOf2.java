package main.java.com.leetcode._869;

import java.util.Arrays;

public class ReorderedPowerOf2 {
    public boolean reorderedPowerOf2(int n) {
        int[] a = count(n);
        for (int i = 0; i < 31; i++) {
            if(Arrays.equals(a, count(1 << i))){
                return true;
            }
        }
        return false;
    }

    private int[] count(int n) {
        int[] ans = new int[10];
        while (n>0){
            ans[n%10]++;
            n/=10;
        }
        return ans;
    }

    public static void main(String[] args) {
        ReorderedPowerOf2 reorderedPowerOf2 = new ReorderedPowerOf2();
        System.out.println(reorderedPowerOf2.reorderedPowerOf2(1));//Output: true
        System.out.println(reorderedPowerOf2.reorderedPowerOf2(10));//Output: false
    }
}
