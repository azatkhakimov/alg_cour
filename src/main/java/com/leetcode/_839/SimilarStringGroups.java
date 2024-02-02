package main.java.com.leetcode._839;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimilarStringGroups {
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(isSimilar(strs[i], strs[j])){
                    adj.computeIfAbsent(i, k->new ArrayList<>()).add(j);
                    adj.computeIfAbsent(j, k->new ArrayList<>()).add(i);
                }
            }
        }
        boolean[] visit = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(!visit[i]){
                dfs(i, adj, visit);
                count++;
            }
        }
        return count;
    }

    private void dfs(int node, Map<Integer, List<Integer>> adj, boolean[] visit) {
        visit[node] = true;
        if(!adj.containsKey(node)){
            return;
        }
        for (Integer neighbor : adj.get(node)) {
            if(!visit[neighbor]){
                visit[neighbor]  = true;
                dfs(neighbor, adj, visit);
            }
        }
    }

    private boolean isSimilar(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)){
                diff++;
            }
        }
        return diff == 0 || diff == 2;
    }


    public static void main(String[] args) {
        SimilarStringGroups s = new SimilarStringGroups();
        System.out.println(s.numSimilarGroups(new String[]{"tars","rats","arts","star"}));//Output: 2
        System.out.println(s.numSimilarGroups(new String[]{"omv","ovm"}));//Output: 1
    }
}
