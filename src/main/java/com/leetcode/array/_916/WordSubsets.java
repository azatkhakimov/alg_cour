package main.java.com.leetcode.array._916;

import java.util.ArrayList;
import java.util.List;

public class WordSubsets {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();
        int[] maxWords2Freq = new int[26];

        for (int i = 0; i < words2.length; i++) {
            String word = words2[i];
            int[] charFreq = getCharFreq(word);

            for (int j = 0; j < 26; j++) {
                maxWords2Freq[j] = Math.max(maxWords2Freq[j], charFreq[j]);
            }
        }
        for (int i = 0; i < words1.length; i++) {
            String word = words1[i];
            int[] charCount = getCharFreq(word);

            boolean valid = true;
            for (int j = 0; j < 26; j++) {
                if(maxWords2Freq[j] > charCount[j]){
                    valid = false;
                    break;
                }
            }
            if(valid){
                result.add(word);
            }
        }
        return result;
    }

    private int[] getCharFreq(String word) {
        int [] result = new int[26];
        for (char c : word.toCharArray()) {
            result[c-'a']++;
        }
        return result;
    }

    public static void main(String[] args) {
        WordSubsets wordSubsets = new WordSubsets();
        System.out.println(wordSubsets.wordSubsets(new String[]{"amazon","apple","facebook","google","leetcode"}
                ,new String[]{"e","o"}));//Output: ["facebook","google","main.java.com.leetcode"]
        System.out.println(wordSubsets.wordSubsets(new String[]{"amazon","apple","facebook","google","leetcode"},
                new String[]{"l","e"}));//Output: ["apple","google","main.java.com.leetcode"]
    }
}
