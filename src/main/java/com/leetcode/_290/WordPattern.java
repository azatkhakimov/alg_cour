package main.java.com.leetcode._290;

import java.util.HashMap;
import java.util.Map;

//https://www.youtube.com/watch?v=dnlB0lvz5LY
public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] str = s.split(" ");
        if(pattern.length() != str.length){
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.toCharArray().length; i++) {
            char curr = pattern.charAt(i);
            if(map.containsKey(curr)) {
                if(!map.get(curr).equals(str[i])){
                    return false;
                }
            }else {
                if(map.containsValue(str[i])){
                    return false;
                }
                map.put(curr, str[i]);
            }
        }
        return true;

    }


    public static void main(String[] args) {
        WordPattern wordPattern = new WordPattern();
        System.out.println(wordPattern.wordPattern("abba", "dog cat cat dog"));//Output: true
        System.out.println(wordPattern.wordPattern( "abba","dog cat cat fish"));//Output: false
        System.out.println(wordPattern.wordPattern("aaaa",  "dog cat cat dog"));//Output: false
    }
}
