package main.java.com.leetcode._1239;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
public class MaximumLengthOfaConcatenatedStringWithUniqueCharacters {
    int result = 0;
    public int maxLength(List<String> arr) {
        dfs(0, arr, "");
        return result;
    }

    private void dfs(int start, List<String> arr, String s) {
        if(!isUnique(s)){
            return;
        }
        result = Math.max(result, s.length());
        for (int i = start; i < arr.size(); i++) {
            String elemStr = arr.get(i);
            dfs(i+1, arr, s+elemStr);
        }
    }

    private boolean isUnique(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if(set.contains(c)){
                return false;
            }
            set.add(c);
        }
        return true;
    }

    public static void main(String[] args) {
        MaximumLengthOfaConcatenatedStringWithUniqueCharacters uniq = new MaximumLengthOfaConcatenatedStringWithUniqueCharacters();
        System.out.println(uniq.maxLength(Arrays.asList("un","iq","ue")));//Output: 4
        System.out.println(uniq.maxLength(Arrays.asList("cha","r","act","ers")));//Output: 6
        System.out.println(uniq.maxLength(Arrays.asList("abcdefghijklmnopqrstuvwxyz")));//Output: 26
    }
}
