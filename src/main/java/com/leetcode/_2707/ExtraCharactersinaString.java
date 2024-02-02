package main.java.com.leetcode._2707;


import java.util.HashMap;
import java.util.Map;

public class ExtraCharactersinaString {
    class TrieNode{
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord = false;
    }

    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        TrieNode root = buildTrie(dictionary);
        int[] dp = new int[n+1];
        for (int start = n-1; start >= 0; start--) {
            dp[start] = dp[start+1]+1;
            TrieNode node = root;
            for (int end = start; end < n; end++) {
                if(!node.children.containsKey(s.charAt(end))){
                    break;
                }
                node = node.children.get(s.charAt(end));
                if(node.isWord){
                    dp[start] = Math.min(dp[start], dp[end+1]);
                }
            }
        }
        return dp[0];
    }

    private TrieNode buildTrie(String[] dictionary) {
        var root = new TrieNode();
        for (String word : dictionary) {
            var node = root;
            for (char c : word.toCharArray()) {
                node.children.putIfAbsent(c, new TrieNode());
                node = node.children.get(c);
            }
            node.isWord = true;
        }
        return root;
    }

    public static void main(String[] args) {
        var e = new ExtraCharactersinaString();
        System.out.println(e.minExtraChar("leetscode", new String[]{"leet","code","leetcode"}));//Output: 1
        System.out.println(e.minExtraChar("sayhelloworld", new String[]{"hello","world"}));//Output: 3
    }
}
