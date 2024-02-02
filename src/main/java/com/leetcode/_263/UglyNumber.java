package main.java.com.leetcode._263;

public class UglyNumber {
    public boolean isUgly(int n) {
        if (n < 1) {
            return false;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 5 == 0) {
            n /= 5;
        }
        return n == 1;
    }


    public static void main(String[] args) {
        UglyNumber uglyNumber = new UglyNumber();
        System.out.println(uglyNumber.isUgly(6));//Output: true
        System.out.println(uglyNumber.isUgly(1));//Output: true
        System.out.println(uglyNumber.isUgly(14));//Output: false
    }
}
