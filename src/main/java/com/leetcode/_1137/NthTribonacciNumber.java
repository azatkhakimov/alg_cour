package main.java.com.leetcode._1137;

public class NthTribonacciNumber {

    public int tribonacci(int n) {
        int[] tri = new int[n+3];
        tri[0] = 0;
        tri[1] = tri[2] = 1;
        for (int i = 3; i <= n; i++) {
            tri[i] = tri[i-1]+tri[i-2]+tri[i-3];
        }
        return tri[n];
    }

    public static void main(String[] args) {
        NthTribonacciNumber nthTribonacciNumber = new NthTribonacciNumber();
        System.out.println(nthTribonacciNumber.tribonacci(4));//Output: 4
        System.out.println(nthTribonacciNumber.tribonacci(25));//Output: 1389537
    }
}
