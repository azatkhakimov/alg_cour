package leetcode._342;

public class PowerOfFour {
    public boolean isPowerOfFour(int n) {
        long ans = 1;
        while(ans < n){
            ans *= 4;
        }
        return ans == n;
    }

    public static void main(String[] args) {
        PowerOfFour powerOfFour = new PowerOfFour();
        System.out.println(powerOfFour.isPowerOfFour(16));//Output: true
        System.out.println(powerOfFour.isPowerOfFour(5));//Output: false
        System.out.println(powerOfFour.isPowerOfFour(1));//Output: true
    }
}
