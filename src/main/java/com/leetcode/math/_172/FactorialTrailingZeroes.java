package main.java.com.leetcode.math._172;

public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int count = 0;
        while(n != 0){
            int temp = n / 5;
            count += temp;
            n = temp;
        }

        return count;

    }
    public static void main(String[] args) {
        FactorialTrailingZeroes factorialTrailingZeroes = new FactorialTrailingZeroes();
        System.out.println(factorialTrailingZeroes.trailingZeroes(3));//Output: 0
        System.out.println(factorialTrailingZeroes.trailingZeroes(25));
        System.out.println(factorialTrailingZeroes.trailingZeroes(10));
    }
}
