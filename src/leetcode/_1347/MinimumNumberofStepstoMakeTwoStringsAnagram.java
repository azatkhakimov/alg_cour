package leetcode._1347;

import java.util.HashMap;
import java.util.Map;

public class MinimumNumberofStepstoMakeTwoStringsAnagram {

    public int minSteps(String s, String t) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[t.charAt(i)-'a']++;
            count[s.charAt(i)-'a']--;
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans += Math.max(0, count[i]);
        }
        return ans;
    }


    public static void main(String[] args) {
        var m = new MinimumNumberofStepstoMakeTwoStringsAnagram();
        System.out.println(m.minSteps("bab",  "aba"));//Output: 1
        System.out.println(m.minSteps("leetcode",  "practice"));//Output: 5
        System.out.println(m.minSteps( "anagram",  "mangaar"));//Output: 0
    }
}
