package main.java.com.leetcode._1647;

import java.util.HashSet;
import java.util.Set;

public class MinimumDeletionstoMakeCharacterFrequenciesUnique {

    public int minDeletions(String s) {
        int[] cnt =  new int[26];
        int res = 0;
        Set<Integer> used = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            ++cnt[s.charAt(i)-'a'];
        }
        for(int i = 0; i < 26; i++){
            while (cnt[i] > 0 && !used.add(cnt[i])){
                --cnt[i];
                ++res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        var m = new MinimumDeletionstoMakeCharacterFrequenciesUnique();
        System.out.println(m.minDeletions("aab"));//Output: 0
        System.out.println(m.minDeletions( "aaabbbcc"));//Output: 2
        System.out.println(m.minDeletions("ceabaacb"));//Output: 2
    }
}
