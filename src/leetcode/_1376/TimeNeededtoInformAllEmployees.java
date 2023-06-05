package leetcode._1376;

import java.util.ArrayList;
import java.util.List;

public class TimeNeededtoInformAllEmployees {
    int maxTime = Integer.MIN_VALUE;
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> adjList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            if(manager[i] != -1){
                adjList.get(manager[i]).add(i);
            }
        }
        dfs(adjList, informTime, headID, 0);
        return maxTime;
    }

    private void dfs(List<List<Integer>> adjList, int[] informTime, int curr, int time) {
        maxTime = Math.max(maxTime, time);
        for (Integer adjacent : adjList.get(curr)) {
            dfs(adjList, informTime, adjacent, time+informTime[curr]);
        }
    }

    public static void main(String[] args) {
        var t = new TimeNeededtoInformAllEmployees();
        System.out.println(t.numOfMinutes(
                1,0,new int[]{-1},new int[]{0}
        ));//Output: 0
        System.out.println(t.numOfMinutes(
                6, 2, new int[]{2,2,-1,2,2,2}, new int[]{0,0,1,0,0,0}
        ));//Output: 1
    }
}
