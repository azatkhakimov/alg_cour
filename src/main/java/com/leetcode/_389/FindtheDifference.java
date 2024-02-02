package main.java.com.leetcode._389;

public class FindtheDifference {

    public char findTheDifference(String s, String t) {
        char c = 0;
        for (char cs : s.toCharArray()) {
            c ^= cs;
        }
        for (char ct : t.toCharArray()) {
            c ^= ct;
        }
        return c;
    }

    public static void main(String[] args) {
      var f = new FindtheDifference();
        System.out.println(f.findTheDifference( "abcd",  "abcde"));//Output: "e"
        System.out.println(f.findTheDifference("", "y"));//Output: "y"
    }
}
