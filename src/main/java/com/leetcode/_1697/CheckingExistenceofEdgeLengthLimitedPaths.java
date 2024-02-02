package main.java.com.leetcode._1697;

import java.util.Arrays;
import java.util.Comparator;

public class CheckingExistenceofEdgeLengthLimitedPaths {

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        UnionFind unionFind = new UnionFind(n);
        int queriesCount = queries.length;
        boolean[] answer = new boolean[queriesCount];
        int[][] queriesWithIndex = new int[queriesCount][4];
        for (int i = 0; i < queriesCount; i++) {
            queriesWithIndex[i][0] = queries[i][0];
            queriesWithIndex[i][1] = queries[i][1];
            queriesWithIndex[i][2] = queries[i][2];
            queriesWithIndex[i][3] = i;
        }
        Arrays.sort(edgeList, Comparator.comparingInt(a -> a[2]));
        Arrays.sort(queriesWithIndex, Comparator.comparingInt(a -> a[2]));
        int edgesIndex = 0;
        for (int queryIndex = 0; queryIndex < queriesCount; queryIndex++) {
            int p = queriesWithIndex[queryIndex][0];
            int q = queriesWithIndex[queryIndex][1];
            int limit = queriesWithIndex[queryIndex][2];
            int queryOriginalIndex = queriesWithIndex[queryIndex][3];
            while (edgesIndex < edgeList.length && edgeList[edgesIndex][2] < limit) {
                int node1 = edgeList[edgesIndex][0];
                int node2 = edgeList[edgesIndex][1];
                unionFind.join(node1, node2);
                edgesIndex++;
            }
            answer[queryOriginalIndex] = unionFind.areConnected(p, q);
        }
        return answer;
    }

    class UnionFind {
        private int[] group;
        private int[] rank;

        UnionFind(int size) {
            group = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                group[i] = i;
            }
        }

        private int find(int node) {
            if (group[node] != node) {
                group[node] = find(group[node]);
            }
            return group[node];
        }

        public void join(int node1, int node2) {
            int group1 = find(node1);
            int group2 = find(node2);
            if (group1 == group2) {
                return;
            }
            if (rank[group1] > rank[group2]) {
                group[group2] = group1;
            } else if (rank[group1] < rank[group2]) {
                group[group1] = group2;
            } else {
                group[group1] = group2;
                rank[group2] += 1;
            }
        }

        public boolean areConnected(int node1, int node2) {
            int group1 = find(node1);
            int group2 = find(node2);
            return group1 == group2;
        }
    }

    public static void main(String[] args) {
        CheckingExistenceofEdgeLengthLimitedPaths c = new CheckingExistenceofEdgeLengthLimitedPaths();
        System.out.println(Arrays.toString(c.distanceLimitedPathsExist(3,
                new int[][]{{0, 1, 2}, {1, 2, 4}, {2, 0, 8}, {1, 0, 16}}, new int[][]{{0, 1, 2}, {0, 2, 5}})));//Output: [false,true]
        System.out.println(Arrays.toString(c.distanceLimitedPathsExist(5,
                new int[][]{{0, 1, 10}, {1, 2, 5}, {2, 3, 9}, {3, 4, 13}}, new int[][]{{0, 4, 14}, {1, 4, 13}})));//Output: [true,false]
    }
}
