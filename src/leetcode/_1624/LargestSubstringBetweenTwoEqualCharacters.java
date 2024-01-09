package leetcode._1624;

import java.util.HashMap;
import java.util.Map;

public class LargestSubstringBetweenTwoEqualCharacters {

    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, Integer> firstIndex = new HashMap<>();
        int ans = -1;
        for (int i = 0; i < s.length(); i++) {
            if(firstIndex.containsKey(s.charAt(i))){
                ans = Math.max(ans, i-firstIndex.get(s.charAt(i))-1);
            }else {
                firstIndex.put(s.charAt(i), i);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        var l = new LargestSubstringBetweenTwoEqualCharacters();
        System.out.println(l.maxLengthBetweenEqualCharacters("aa"));//Output: 0
        System.out.println(l.maxLengthBetweenEqualCharacters("abca"));//Output: 2
        System.out.println(l.maxLengthBetweenEqualCharacters("cbzxy"));//Output: -1
    }
}
