package main.java.com.leetcode._1061;

import java.util.ArrayList;
import java.util.List;

public class LexicographicallySmallestEquivalentString {
    private int minChar;

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        Integer[][] adjMatrix = new Integer[26][26];
        for (int i = 0; i < s1.length(); i++) {
            adjMatrix[s1.charAt(i) - 'a'][s2.charAt(i) - 'a'] = 1;
            adjMatrix[s2.charAt(i) - 'a'][s1.charAt(i) - 'a'] = 1;
        }
        int [] mappingChar = new int[26];
        for (int i = 0; i < 26; i++) {
            mappingChar[i] = i;
        }

        Integer[] visited = new Integer[26];
        for (int i = 0; i < 26; i++) {
            if(visited[i] == null){
                List<Integer> component = new ArrayList<>();
                minChar = 27;
                dfs(i, adjMatrix, visited, component);

                for (Integer vertex : component) {
                    mappingChar[vertex] = minChar;
                }
            }
        }

        String ans = "";
        for (char c : baseStr.toCharArray()) {
            ans += (char)(mappingChar[c-'a']+'a');
        }
        return ans;
    }

    private void dfs(int src, Integer[][] adjMatrix, Integer[] visited, List<Integer> component) {
        visited[src] = 1;
        component.add(src);
        minChar = Math.min(minChar, src);
        for (int i = 0; i < 26; i++) {
            if(adjMatrix[src][i] != null && visited[i] == null){
                dfs(i, adjMatrix, visited, component);
            }
        }
    }

    public static void main(String[] args) {
        LexicographicallySmallestEquivalentString string = new LexicographicallySmallestEquivalentString();
        System.out.println(string.smallestEquivalentString(
                "parker", "morris", "parser"));//Output: "makkek"
        System.out.println(string.smallestEquivalentString(
                "hello", "world", "hold"));//Output: "hdld"
        System.out.println(string.smallestEquivalentString(
                "leetcode", "programs", "sourcecode"));//Output: "aauaaaaada"
    }
}
