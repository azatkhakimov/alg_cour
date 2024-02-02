package main.java.com.leetcode._438;

import java.util.*;


//https://www.youtube.com/watch?v=fvEw13A5O1o
public class FindAllAnagramsInaString {


    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();

        int[] charsCount = new int[26];
        for (char c : p.toCharArray()) {
            charsCount[c-'a']++;
        }
        int left = 0;
        int right = 0;
        int count = p.length();

        while(right < s.length()){
            if(charsCount[s.charAt(right++)-'a']-- >= 1){
                count--;
            }
            if(count == 0){
                ans.add(left);
            }
            if(right - left == p.length() && charsCount[s.charAt(left++)-'a']++>=0){
                count++;
            }
        }
        return ans;

    }


    public static void main(String[] args) {
        FindAllAnagramsInaString anagrams = new FindAllAnagramsInaString();
        System.out.println(anagrams.findAnagrams("cbaebabacd", "abc"));//Output: [0,6]
        System.out.println(anagrams.findAnagrams("abab", "ab"));//Output: [0,1,2]
    }
}
