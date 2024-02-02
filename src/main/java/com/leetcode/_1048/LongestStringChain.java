package main.java.com.leetcode._1048;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {

    public int longestStrChain(String[] words) {
        Map<String, Integer> dp = new HashMap<>();
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int res = 0;
        for (String word : words) {
            int best = 0;
            for (int i = 0; i < word.length(); i++) {
                String prev = word.substring(0, i) + word.substring(i+1);
                best = Math.max(best, dp.getOrDefault(prev, 0)+1);
            }
            dp.put(word, best);
            res = Math.max(res, best);
        }
        return res;
    }

    public static void main(String[] args) {
       var l  = new LongestStringChain();
        System.out.println(l.longestStrChain(new String[]{"a","b","ba","bca","bda","bdca"}));//Output: 4
        System.out.println(l.longestStrChain(new String[]{"xbc","pcxbcf","xb","cxbc","pcxbc"}));//Output: 5
        System.out.println(l.longestStrChain(new String[]{"abcd","dbqca"}));//Output: 1
    }
}
