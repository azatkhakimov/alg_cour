package main.java.com.leetcode._1220;

import java.util.HashMap;
import java.util.Map;

public class CountVowelsPermutation {
    private Map<String, Long> memo = new HashMap<>();
    private int MOD = 1000000007;
    public int countVowelPermutation(int n) {
        long total = 0;
        char[] chars = new char[]{'a', 'e','i','o','u'};
        for (char aChar : chars) {
            total = (total+helper(n-1, aChar)) % MOD;
        }
        return (int) total;
    }

    private long helper(int remainingChars, char prevChar) {
        if(remainingChars == 0){
            return 1;
        }
        String key = ""+remainingChars+prevChar;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        long total = 0;
        switch (prevChar){
            case 'a':
                total = (helper(remainingChars-1, 'e')) % MOD;
                break;
            case 'e':
                total = (helper(remainingChars-1, 'a')+helper(remainingChars-1, 'i'))%MOD;
                break;
            case 'i':
                total = (helper(remainingChars-1, 'a')+helper(remainingChars-1, 'e')
                        +helper(remainingChars-1, 'o')+helper(remainingChars-1, 'u'))%MOD;
                break;
            case 'o':
                total = (helper(remainingChars-1, 'i')+helper(remainingChars-1, 'u'))%MOD;
                break;
            case 'u':
                total = (helper(remainingChars-1, 'a'))%MOD;
                break;
        }
        memo.put(key, total);
        return total;
    }

    public static void main(String[] args) {
        CountVowelsPermutation countVowelsPermutation = new CountVowelsPermutation();
        System.out.println(countVowelsPermutation.countVowelPermutation(1));//Output: 5
        System.out.println(countVowelsPermutation.countVowelPermutation(2));//Output: 10
        System.out.println(countVowelsPermutation.countVowelPermutation(5));//Output: 68
    }
}
