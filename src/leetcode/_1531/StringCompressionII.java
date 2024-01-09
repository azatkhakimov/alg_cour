package leetcode._1531;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StringCompressionII {
    private Map<Integer, Integer> memo = new HashMap<>();
    Set<Integer> add = Set.of(1, 9, 99);

    public int getLengthOfOptimalCompression(String s, int k) {
        return dp(s, 0, (char) ('a' + 26), 0, k);
    }

    private int dp(String s, int idx, char lastChar, int lastCharCount, int k) {
        if (k < 0) {
            return Integer.MAX_VALUE / 2;
        }

        if(idx == s.length()){
            return 0;
        }

        int key = idx * 101 * 27 * 101 + (lastChar - 'a') * 101 * 101 + lastCharCount * 101 + k;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int keepChar;
        int deleteChar = dp(s, idx + 1, lastChar, lastCharCount, k - 1);
        if (s.charAt(idx) == lastChar) {
            keepChar = dp(s, idx + 1, lastChar, lastCharCount + 1, k) + (add.contains(lastCharCount) ? 1 : 0);
        }
        else {
            keepChar = dp(s, idx + 1, s.charAt(idx), 1, k) + 1;
        }
        int res = Math.min(keepChar, deleteChar);
        memo.put(key, res);
        return res;
    }


    public static void main(String[] args) {
        StringCompressionII stringCompression = new StringCompressionII();
        System.out.println(stringCompression.getLengthOfOptimalCompression("aaabcccd", 2));//Output: 4
        System.out.println(stringCompression.getLengthOfOptimalCompression("aabbaa", 2));//Output: 2
        System.out.println(stringCompression.getLengthOfOptimalCompression("aaaaaaaaaaa", 0));//Output: 3
    }
}
