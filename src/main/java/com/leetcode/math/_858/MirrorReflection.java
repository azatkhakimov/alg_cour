package main.java.com.leetcode.math._858;

public class MirrorReflection {
    public int mirrorReflection(int p, int q) {
        int m = q;
        int n = p;

        while (m % 2 == 0 && n % 2 == 0){
            m /= 2;
            n /= 2;
        }
        if(m%2 == 0 && n%2 == 1){
            return 0;
        }
        if(m%2 == 1 && n % 2 == 1) {
            return 1;
        }
        if(m % 2 == 1 && n % 2 == 0){
            return 2;
        }
        return -1;
    }
    public static void main(String[] args) {
        MirrorReflection mirrorReflection = new MirrorReflection();
        System.out.println(mirrorReflection.mirrorReflection(2,1));//Output: 2
        System.out.println(mirrorReflection.mirrorReflection(3,1));//Output: 1
    }
}
