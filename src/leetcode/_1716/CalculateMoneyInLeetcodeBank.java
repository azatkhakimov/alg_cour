package leetcode._1716;

public class CalculateMoneyInLeetcodeBank {

    public int totalMoney(int n) {
        int k = n / 7;
        int F = 28;
        int L = 28 + (k - 1)*7;
        int arithmeticSum = k * (F+L)/2;

        int monday = 1 + k;
        int finalWeek  = 0;
        for (int day = 0; day < n % 7; day++) {
            finalWeek += monday + day;
        }
        return arithmeticSum + finalWeek;
    }

    public static void main(String[] args) {
        var c = new CalculateMoneyInLeetcodeBank();
        System.out.println(c.totalMoney(4));//Output: 10
        System.out.println(c.totalMoney(10));//Output: 37
        System.out.println(c.totalMoney(20));//Output: 96
    }
}
