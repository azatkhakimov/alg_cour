package main.java.com.leetcode._1897;

import java.util.HashMap;
import java.util.Map;

public class RedistributeCharacterstoMakeAllStringsEqual {

    public boolean makeEqual(String[] words) {
        Map<Character, Integer> counts = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                counts.put(c, counts.getOrDefault(c, 0)+1);
            }
        }
        int n = words.length;
        for (Character c : counts.keySet()) {
            Integer val = counts.get(c);
            if(val % n != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        var r = new RedistributeCharacterstoMakeAllStringsEqual();
        System.out.println(r.makeEqual(new String[]{"abc","aabc","bc"}));//Output: true
        System.out.println(r.makeEqual(new String[]{"ab","a"}));//Output: false
    }
}
