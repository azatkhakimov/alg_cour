package leetcode.string._242;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> counter = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            counter.put(character, counter.getOrDefault(character, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            if (!counter.containsKey(t.charAt(i))) {
                return false;
            }
            counter.put(t.charAt(i), counter.get(t.charAt(i)) - 1);
        }
        for (Integer value : counter.values()) {
            if (value > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        System.out.println(validAnagram.isAnagram("anagram", "nagaram"));//Output: true
        System.out.println(validAnagram.isAnagram("rat", "car"));//Output: false
    }

}
