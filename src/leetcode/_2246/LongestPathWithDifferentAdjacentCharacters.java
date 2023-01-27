package leetcode._2246;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestPathWithDifferentAdjacentCharacters {
    private int longestPath = 1;

    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        Map<Integer, List<Integer>> children = new HashMap<>();
        for (int i = 0; i < n; i++) {
            children.computeIfAbsent(parent[i], value -> new ArrayList<>()).add(i);
        }

        dfs(0, children, s);
        return longestPath;
    }

    private int dfs(int currentNode, Map<Integer, List<Integer>> children, String s) {
        if(!children.containsKey(currentNode)){
            return 1;
        }
        int longestChain = 0;
        int secondLongestChains = 0;

        for (Integer child : children.get(currentNode)) {
            int longestChainStartingFromChild = dfs(child, children, s);

            if(s.charAt(currentNode) == s.charAt(child)){
                continue;
            }

            if(longestChainStartingFromChild > longestChain){
                secondLongestChains = longestChain;
                longestChain = longestChainStartingFromChild;
            } else if (longestChainStartingFromChild > secondLongestChains) {
                secondLongestChains = longestChainStartingFromChild;
            }
        }

        longestPath = Math.max(longestPath, longestChain+secondLongestChains+1);
        return longestChain+1;
    }


    public static void main(String[] args) {
        LongestPathWithDifferentAdjacentCharacters path = new LongestPathWithDifferentAdjacentCharacters();
        System.out.println(path.longestPath(new int[]{-1, 0, 0, 1, 1, 2}, "abacbe"));//Output: 3
        System.out.println(path.longestPath(new int[]{-1, 0, 0, 0}, "aabc"));//Output: 3
    }
}
