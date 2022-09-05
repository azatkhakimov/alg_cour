package leetcode._131;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/palindrome-partitioning/solution/
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        List<List<String>> result = new ArrayList<>();
        dfs(result, s, 0, new ArrayList<>(), dp);
        return result;
    }

    private void dfs(List<List<String>> result, String s, int start, ArrayList<String> currentList, boolean[][] dp) {
        if(start >= s.length()){
            result.add(new ArrayList<>(currentList));
        }
        for (int end = start; end < s.length(); end++) {
            if(s.charAt(start) == s.charAt(end) && (end-start <= 2 || dp[start+1][end-1])){
                dp[start][end] = true;
                currentList.add(s.substring(start, end+1));
                dfs(result, s, end+1, currentList, dp);
                currentList.remove(currentList.size()-1);
            }
        }

    }

    public static void main(String[] args) {
        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
        System.out.println(palindromePartitioning.partition("aab"));//Output: [["a","a","b"],["aa","b"]]
        System.out.println(palindromePartitioning.partition("a"));//Output: [["a"]]x
    }
}
