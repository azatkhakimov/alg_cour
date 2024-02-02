package main.java.com.leetcode._1611;

public class MinimumOneBitOperationsToMakeIntegersZero {


    public int minimumOneBitOperations(int n) {
        if(n == 0){
            return 0;
        }

        int k = 0;
        int curr = 1;
        while (curr * 2 <= n){
            curr *= 2;
            k++;
        }

        return (1 << (k+1))-1-minimumOneBitOperations(n ^ curr);
    }

    public static void main(String[] args) {
        var m = new MinimumOneBitOperationsToMakeIntegersZero();
        System.out.println(m.minimumOneBitOperations(3));//Output: 2
        System.out.println(m.minimumOneBitOperations(6));//Output: 4
    }
}
