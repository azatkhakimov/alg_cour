package main.java.com.leetcode._242;

import java.util.Arrays;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        Arrays.sort(sChar);
        Arrays.sort(tChar);
        return Arrays.equals(sChar, tChar);
    }

    public static void main(String[] args) {
        var v = new ValidAnagram();
        System.out.println(v.isAnagram("anagram", "nagaram"));//Output: true
        System.out.println(v.isAnagram("rat", "car"));//Output: false
    }
}
