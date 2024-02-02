package main.java.com.leetcode._2264;

import java.util.List;

public class Largest3SameDigitNumberInString {

    public String largestGoodInteger(String num) {
        List<String> sameDigitNumbers = List.of("999", "888", "777", "666", "555", "444", "333", "222", "111", "000");
        for (String sameDigitNumber : sameDigitNumbers) {
            if(contains(sameDigitNumber, num)){
                return sameDigitNumber;
            }
        }
        return "";
    }

    private boolean contains(String sameDigitNumber, String num) {
        for (int i = 0; i <= num.toCharArray().length-3; i++) {
            if(sameDigitNumber.charAt(0) == num.charAt(i) &&
                    sameDigitNumber.charAt(1) == num.charAt(i+1) &&
                    sameDigitNumber.charAt(2) == num.charAt(i+2)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        var l = new Largest3SameDigitNumberInString();
        System.out.println(l.largestGoodInteger("6777133339"));//Output: "777"
        System.out.println(l.largestGoodInteger("2300019"));//Output: "000"
        System.out.println(l.largestGoodInteger( "42352338"));//Output: ""
    }
}
