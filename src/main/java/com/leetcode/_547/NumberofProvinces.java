package main.java.com.leetcode._547;

public class NumberofProvinces {

    public int findCircleNum(int[][] isConnected) {
        int numberOfComponents = 0;
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                numberOfComponents++;
                dfs(i, isConnected, visited);
            }
        }

        return numberOfComponents;
    }

    public void dfs(int node, int[][] isConnected, boolean[] visit) {
        visit[node] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if(isConnected[node][i] == 1 && !visit[i]){
                dfs(i, isConnected, visit);
            }
        }
    }

    public static void main(String[] args) {
        var n = new NumberofProvinces();
        System.out.println(n.findCircleNum(new int[][]{{1,1,0},{1,1,0},{0,0,1}}));//Output: 2
        System.out.println(n.findCircleNum(new int[][]{{1,0,0},{0,1,0},{0,0,1}}));//Output: 3
    }
}
