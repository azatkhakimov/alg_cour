package main.java.com.leetcode.string._792;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class NumberOfMatchingSubsequences {
    public int numMatchingSubseq(String s, String[] words) {
        Map<Character, Queue<String>> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            map.putIfAbsent(s.charAt(i), new LinkedList<>());
        }

        for (String word : words) {
            char startChar = word.charAt(0);
            if(map.containsKey(startChar)){
                map.get(startChar).offer(word);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            char startChar = s.charAt(i);
            Queue<String> queue = map.get(startChar);
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                String str = queue.poll();
                if(str.substring(1).length() == 0){
                    ans++;
                }else {
                    if (map.containsKey(str.charAt(1))) {
                        map.get(str.charAt(1)).add(str.substring(1));
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        NumberOfMatchingSubsequences test = new NumberOfMatchingSubsequences();
        System.out.println(test.numMatchingSubseq( "abcde", new String[] {"a","bb","acd","ace"}));//Output: 3
        System.out.println(test.numMatchingSubseq("dsahjpjauf", new String[]{"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"}));//Output: 2
    }

}
