package leetcode._76;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

//https://www.youtube.com/watch?v=eS6PZLjoaq8
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if(t == null || t.length() == 0){
            return "";
        }

        Map<Character, Integer> rCount = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            rCount.put(c, rCount.getOrDefault(c,0)+1);
        }
        int l = 0;
        int r = 0;
        int current = 0;
        int required = rCount.size();
        int result = Integer.MAX_VALUE;
        int start = 0;
        while (r < s.length()){
            Character c = s.charAt(r);
            r++;
            if(rCount.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0)+1);
                if(Objects.equals(window.get(c), rCount.get(c))){
                    current++;
                }
            }

            while (current == required){
                if(r-l < result){
                    start = l;
                    result = r-l;
                }

                Character d = s.charAt(l);
                l++;
                if(rCount.containsKey(d)){
                    if(window.get(d).equals(rCount.get(d))){
                        current--;
                    }
                    window.put(d, window.get(d)-1);
                }
            }
        }
        return result == Integer.MAX_VALUE ? "" : s.substring(start, start+result);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring m = new MinimumWindowSubstring();
        System.out.println(m.minWindow("ADOBECODEBANC", "ABC"));//Output: "BANC"
        System.out.println(m.minWindow("a", "a"));//Output: "a"
        System.out.println(m.minWindow("a", "aa"));//Output: ""
    }
}
