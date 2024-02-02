package main.java.com.leetcode._3;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int windowStart = 0;
        int windowLength = 0;
        int longest = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), i);
            }else {
                int prevOccurence = map.get(s.charAt(i));
                if(prevOccurence >= windowStart){
                    windowLength = i - windowStart;
                    longest = Math.max(longest, windowLength);
                    windowStart = prevOccurence+1;
                }
                map.put(s.charAt(i), i);
            }
        }

        if (longest < n - windowStart) {
            longest = n - windowStart;
        }
        return longest;
    }


    public static void main(String[] args) {
        var l = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(l.lengthOfLongestSubstring("abcabcbb"));//Output: 3
        System.out.println(l.lengthOfLongestSubstring("bbbbb"));//Output: 1
        System.out.println(l.lengthOfLongestSubstring("pwwkew"));//Output: 3
        System.out.println(l.lengthOfLongestSubstring("au"));//2
    }
}
