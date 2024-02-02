package main.java.com.leetcode._2421;

public class UnionFind {
    private final int[] parent;
    private final int[] rank;

    public UnionFind(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
        rank = new int[size];
    }

    public void setUnion(Integer x, Integer y) {
        int xset = find(x);
        int yset = find(y);
        if(xset == yset){
            return;
        } else if (rank[xset] < rank[yset]) {
            parent[xset] = yset;
        } else if (rank[xset] > rank[yset]) {
            parent[yset] = xset;
        }else {
            parent[yset] = xset;
            rank[xset]++;
        }
    }

    public Integer find(Integer x) {
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
}
