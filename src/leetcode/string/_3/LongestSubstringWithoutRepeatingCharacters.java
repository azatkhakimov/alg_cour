package leetcode.string._3;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < n; j++) {
            char key = s.charAt(j);
            if(map.containsKey(key)){
                i = Math.max(map.get(key), i);
            }
            ans = Math.max(ans, j-i+1);
            map.put(key, j+1);
        }

        return ans;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters test = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(test.lengthOfLongestSubstring("abcabcbb"));
    }
}
