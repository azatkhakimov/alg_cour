package leetcode._131;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/palindrome-partitioning/discuss/182307/Java%3A-Backtracking-Template-General-Approach
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        if(s == null || s.length() == 0){
            return new ArrayList<>();
        }
        List<List<String>> result = new ArrayList<>();
        backtrack(s, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, List<String> step, List<List<String>> result) {
        if(s == null || s.length() == 0){
            result.add(new ArrayList<>(step));
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            String temp = s.substring(0, i);
            if(!isPalindrome(temp)){
                continue;
            }
            step.add(temp);
            backtrack(s.substring(i, s.length()), step, result);
            step.remove(step.size()-1);
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        while(left <= right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
        System.out.println(palindromePartitioning.partition("aab"));//Output: [["a","a","b"],["aa","b"]]
        System.out.println(palindromePartitioning.partition("a"));//Output: [["a"]]x
    }
}
