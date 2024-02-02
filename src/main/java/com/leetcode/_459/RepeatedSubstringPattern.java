package main.java.com.leetcode._459;

public class RepeatedSubstringPattern {


    public boolean repeatedSubstringPattern(String s) {
        String t = s + s;
        String substring = t.substring(1, t.length() - 1);
        if(substring.contains(s)){
            return true;
        }
        else return false;
    }

    public static void main(String[] args) {
        var r = new RepeatedSubstringPattern();
        System.out.println(r.repeatedSubstringPattern("abab"));//Output: true
        System.out.println(r.repeatedSubstringPattern("aba"));//Output: false
        System.out.println(r.repeatedSubstringPattern("abcabcabcabc"));//Output: true
    }
}
