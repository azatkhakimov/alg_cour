package main.java.com.leetcode._2108;

import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class FindFirstPalindromicStringintheArray {

    public String firstPalindrome(String[] words) {
        for (String word : words) {
            if(isPalindrome(word)){
                return word;
            }
        }
        return "";
    }

    private boolean isPalindrome(String word) {
        String reversed = new StringBuilder(word).reverse().toString();
        return word.equals(reversed);
    }

    public static void main(String[] args) {
        var f = new FindFirstPalindromicStringintheArray();
        System.out.println(f.firstPalindrome(new String[]{"abc","car","ada","racecar","cool"}));//Output: "ada"
        System.out.println(f.firstPalindrome(new String[]{"notapalindrome","racecar"}));//Output: "racecar"
        System.out.println(f.firstPalindrome(new String[]{"def","ghi"}));//Output: ""
    }
}
