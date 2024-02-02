package main.java.com.leetcode._191;

public class NumberOf1Bits {


    public int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if((n & mask) != 0){
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }

    public static void main(String[] args) {
        var n = new NumberOf1Bits();
        System.out.println(n.hammingWeight(00000000000000000000000000001011));//Output: 3
        System.out.println(n.hammingWeight(00000000000000000000000010000000));//Output: 1
        //System.out.println(n.hammingWeight(11111111111111111111111111111101));//Output: 31
    }
}
