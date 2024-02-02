package main.java.com.leetcode._2359;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FindClosestNodeToGivenTwoNodes {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);

        bfs(node1, edges, dist1);
        bfs(node2, edges, dist2);

        int minDistNode = -1;
        int minDistTillNow = Integer.MAX_VALUE;
        for (int currNode = 0; currNode < n; currNode++) {
            if (minDistTillNow > Math.max(dist1[currNode], dist2[currNode])) {
                minDistNode = currNode;
                minDistTillNow = Math.max(dist1[currNode], dist2[currNode]);
            }
        }
        return minDistNode;
    }

    private void bfs(int startNode, int[] edges, int[] dist) {
        int n = edges.length;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode);

        Boolean[] visit = new Boolean[n];
        Arrays.fill(visit, Boolean.FALSE);
        dist[startNode] = 0;

        while (!queue.isEmpty()){
            int node = queue.poll();
            if(visit[node]){
                continue;
            }
            visit[node] = true;
            int neighbor = edges[node];
            if(neighbor != -1 && !visit[neighbor]){
                dist[neighbor] = 1 + dist[node];
                queue.offer(neighbor);
            }
        }
    }

    public static void main(String[] args) {
        FindClosestNodeToGivenTwoNodes node = new FindClosestNodeToGivenTwoNodes();
        System.out.println(node.closestMeetingNode(new int[]{2, 2, 3, -1}, 0, 1));//Output: 2
        System.out.println(node.closestMeetingNode(new int[]{1, 2, -1}, 0, 2));//Output: 2
        System.out.println(node.closestMeetingNode(new int[]{5,4,5,4,3,6,-1}, 0 ,1));//-1
    }
}
