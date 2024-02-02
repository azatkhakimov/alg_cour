package main.java.com.leetcode._1523;

public class CountOddNumbersInanIntervalRange {
    public int countOdds(int low, int high) {
        return (high+1)/2 - low/2;
    }


    public static void main(String[] args) {
        CountOddNumbersInanIntervalRange c = new CountOddNumbersInanIntervalRange();
        System.out.println(c.countOdds(3, 7));//Output: 3
        System.out.println(c.countOdds(8, 10));//Output: 1
    }
}
