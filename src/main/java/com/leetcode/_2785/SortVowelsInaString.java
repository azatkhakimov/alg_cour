package main.java.com.leetcode._2785;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortVowelsInaString {

    public String sortVowels(String s) {
        List<Character> temp = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                temp.add(c);
            }
        }
        Collections.sort(temp);

        StringBuilder ans = new StringBuilder();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if(isVowel(s.charAt(i))){
                ans.append(temp.get(j));
                j++;
            }else {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'o' || c == 'u' || c == 'i'
                || c == 'A' || c == 'E' || c == 'O' || c == 'U' || c == 'I';
    }

    public static void main(String[] args) {
        var s = new SortVowelsInaString();
        System.out.println(s.sortVowels("lEetcOde"));//Output: "lEOtcede"
        System.out.println(s.sortVowels("lYmpH"));//Output: "lYmpH"
    }
}
