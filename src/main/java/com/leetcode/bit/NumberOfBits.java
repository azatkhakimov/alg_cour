package main.java.com.leetcode.bit;

public class NumberOfBits {
    public int hammingWeight(int n) {
        int ones = 0;
        while (n != 0) {
            ones = ones + (n & 1);
            n = n >>> 1;
        }
        return ones;
    }

    public static void main(String[] args) {
        NumberOfBits numberOfBits  = new NumberOfBits();
        int i = numberOfBits.hammingWeight(00000000000000000000000000001011);
        System.out.println(i);
    }

}
