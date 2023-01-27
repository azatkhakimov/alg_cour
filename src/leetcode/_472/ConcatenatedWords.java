package leetcode._472;

import java.util.*;

public class ConcatenatedWords {

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> dict = new HashSet<>(Arrays.asList(words));
        List<String> ans = new ArrayList<>();

        for (String word : words) {
            int length = word.length();
            boolean[] dp = new boolean[length + 1];
            dp[0] = true;
            for (int i = 1; i <= length; i++) {
                for (int j = (i == length ? 1 : 0); !dp[i] && j < i; j++) {
                    dp[i] = dp[j] && dict.contains(word.substring(j, i));
                }
            }
            if(dp[length]){
                ans.add(word);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        ConcatenatedWords concatenatedWords = new ConcatenatedWords();
        System.out.println(concatenatedWords.findAllConcatenatedWordsInADict(new String[]{
                "cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"
        }));//Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]

        System.out.println(concatenatedWords.findAllConcatenatedWordsInADict(new String[]{
                "cat", "dog", "catdog"
        }));//Output: ["catdog"]
    }
}
