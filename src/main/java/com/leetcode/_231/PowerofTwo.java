package main.java.com.leetcode._231;

public class PowerofTwo {

    public boolean isPowerOfTwo(int n) {
        if(n == 0){
            return false;
        }
        while (n % 2 == 0){
            n/=2;
        }
        return n==1;
    }

    public static void main(String[] args) {
        var p = new PowerofTwo();
        System.out.println(p.isPowerOfTwo(1));//Output: true
        System.out.println(p.isPowerOfTwo(16));//Output: true
        System.out.println(p.isPowerOfTwo(3));//Output: false
    }
}
