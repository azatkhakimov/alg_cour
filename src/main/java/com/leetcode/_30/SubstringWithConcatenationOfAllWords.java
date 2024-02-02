package main.java.com.leetcode._30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
    private Map<String, Integer> wordCount = new HashMap<>();
    private int n;
    private int wordLength;
    private int substringSize;
    private int k;


    public List<Integer> findSubstring(String s, String[] words) {
        n = s.length();
        k = words.length;
        wordLength = words[0].length();
        substringSize = wordLength * k;

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < wordLength; i++) {
            slidingWindow(i, s, ans);
        }
        return ans;
    }

    private void slidingWindow(int left, String s, List<Integer> ans) {
        Map<String, Integer> wordsFound = new HashMap<>();
        int wordUsed = 0;
        boolean excessWord = false;

        for (int right = left; right <= n - wordLength; right+=wordLength) {
            String sub = s.substring(right, right + wordLength);
            if(!wordCount.containsKey(sub)){
                wordsFound.clear();
                wordUsed = 0;
                excessWord = false;
                left = right +wordLength;
            }else {
                while (right-left == substringSize || excessWord){
                    String leftmostWord = s.substring(left, left+wordLength);
                    left += wordLength;
                    wordsFound.put(leftmostWord, wordsFound.get(leftmostWord)-1);

                    if(wordsFound.get(leftmostWord) >= wordCount.get(leftmostWord)){
                        excessWord = false;
                    }else {
                        wordUsed--;
                    }
                }

                wordsFound.put(sub, wordsFound.getOrDefault(sub, 0)+1);
                if(wordsFound.get(sub) <= wordCount.get(sub)){
                    wordUsed++;
                }else {
                    excessWord = true;
                }

                if (wordUsed == k && !excessWord){
                    ans.add(left);
                }
            }

        }
    }

    public static void main(String[] args) {
        SubstringWithConcatenationOfAllWords test = new SubstringWithConcatenationOfAllWords();
        System.out.println(test.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));//Output: [0,9]
        System.out.println(test.findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"}));//Output: []
        System.out.println(test.findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"}));//Output: [6,9,12]
    }
}
