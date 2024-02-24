package main.java.com.leetcode.bit;

public class ReverseBits {
    public int reverseBits(int n) {
        if (n == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            if((n&1) == 1){
                result++;
            }
            n >>= 1;
        }

        return result;
    }

    public static void main(String[] args) {
        int x = new ReverseBits().reverseBits(13);
        System.out.println(x);
    }
}