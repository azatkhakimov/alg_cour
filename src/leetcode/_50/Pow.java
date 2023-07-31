package leetcode._50;

public class Pow {

    public double myPow(double x, int n) {
        return binaryExp(x, (long) n);
    }

    private double binaryExp(double x, long n) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 1.0 / binaryExp(x, -1 * n);
        }
        if (n % 2 == 1) {
            return x * binaryExp(x * x, (n - 1) / 2);
        } else {
            return binaryExp(x * x, n / 2);
        }
    }

    public static void main(String[] args) {
        var p = new Pow();
        System.out.println(p.myPow(2.00000, 10));//Output: 1024.00000
        System.out.println(p.myPow(2.10000, 3));//Output: 9.26100
        System.out.println(p.myPow(2.00000, -2));//Output: 0.25000
    }
}
