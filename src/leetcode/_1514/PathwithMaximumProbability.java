package leetcode._1514;

//Let nnn be the number of nodes and mmm be the number of edges.
//
//        Time complexity: O(n⋅m)O(n \cdot m)O(n⋅m)
//        The algorithm relaxes all edges in the graph n - 1 times,
//        each round contains an iteration over all m edges.
//
//        Space complexity: O(n)O(n)O(n)
//        We only need an array of size nnn to update the maximum probability
//        to reach each node from the starting node.

public class PathwithMaximumProbability {

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double[] maxProb = new double[n];
        maxProb[start] =  1.0;
        for (int i = 0; i < n - 1; i++) {
            boolean hasUpdate = false;
            for (int j = 0; j < edges.length; j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                double pathProb = succProb[j];
                if(maxProb[u]*pathProb>maxProb[v]){
                    maxProb[v] = maxProb[u]*pathProb;
                    hasUpdate = true;
                }
                if(maxProb[v]*pathProb > maxProb[u]){
                    maxProb[u] = maxProb[v]*pathProb;
                    hasUpdate = true;
                }
            }
            if(!hasUpdate){
                break;
            }
        }
        return maxProb[end];
    }


    public static void main(String[] args) {
        var p = new PathwithMaximumProbability();
        System.out.println(p.maxProbability(
                3,
                new int[][]{{0, 1}, {1, 2}, {0, 2}},
                new double[]{0.5, 0.5, 0.2},
                0,
                2
        ));//Output: 0.25000
        System.out.println(p.maxProbability(
                3,
                new int[][]{{0,1},{1,2},{0,2}},
                new double[]{0.5,0.5,0.3},
                0,
                2
        ));//Output: 0.30000
        System.out.println(p.maxProbability(
                3,
                new int[][]{{0,1}},
                new double[]{0.5},
                0,
                2
        ));//Output: 0.00000
    }
}
