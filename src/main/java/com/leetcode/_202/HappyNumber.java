package main.java.com.leetcode._202;

public class HappyNumber {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = sumOfSquaredDigits(n);
        while (fast != 1 && slow != fast){
            slow = sumOfSquaredDigits(slow);
            fast = sumOfSquaredDigits(sumOfSquaredDigits(fast));
        }
        return fast == 1;
    }
    public int sumOfSquaredDigits(int number){
        int totalSum = 0;
        while (number != 0){
            int digits = number % 10;
            number = number / 10;
            totalSum += (Math.pow(digits, 2));
        }
        return totalSum;
    }




    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        System.out.println(happyNumber.isHappy(19));//Output: true
        System.out.println(happyNumber.isHappy(2));//Output: false
    }
}
