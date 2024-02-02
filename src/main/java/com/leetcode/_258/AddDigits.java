package main.java.com.leetcode._258;

public class AddDigits {
    public int addDigits(int num) {
        if (num == 0){
            return num;
        }
        if(num % 9 == 0){
            return 0;
        }
        return num % 9;
    }

    public static void main(String[] args) {
        AddDigits a = new AddDigits();
        System.out.println(a.addDigits(38));//Output: 2
        System.out.println(a.addDigits(0));//Output: 0
    }
}
