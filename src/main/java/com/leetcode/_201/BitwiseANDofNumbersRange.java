package main.java.com.leetcode._201;

public class BitwiseANDofNumbersRange {

    public int rangeBitwiseAnd(int left, int right) {
        while (left < right){
            right = right & (right - 1);
        }
        return left & right;
    }

    public static void main(String[] args) {
        var b = new BitwiseANDofNumbersRange();
        System.out.println(b.rangeBitwiseAnd(5, 7));//Output: 4
        System.out.println(b.rangeBitwiseAnd(0, 0));//Output: 0
        System.out.println(b.rangeBitwiseAnd(1, 2147483647));//Output: 0
    }
}
