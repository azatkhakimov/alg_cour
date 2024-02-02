package main.java.com.leetcode._1071;

public class GreatestCommonDivisorOfStrings {

    public String gcdOfStrings(String str1, String str2) {
        if(!(str1 + str2).equals(str2 +str1)){
            return "";
        }

        int gcdLength = gcd(str1.length() , str2.length());
        return str1.substring(0, gcdLength);
    }

    private int gcd(int x, int y) {
        if(y == 0){
            return x;
        }else {
            return gcd(y, x % y);
        }
    }

    public static void main(String[] args) {
        GreatestCommonDivisorOfStrings s = new GreatestCommonDivisorOfStrings();
        System.out.println(s.gcdOfStrings("ABCABC", "ABC"));//Output: "ABC"
        System.out.println(s.gcdOfStrings("ABABAB", "ABAB"));//Output: "AB"
        System.out.println(s.gcdOfStrings("LEET", "CODE"));//Output: ""
    }
}
