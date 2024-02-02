package main.java.com.leetcode._587;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;


public class ErectTheFence {

    public int[][] outerTrees(int[][] trees) {
        Stack<int[]> upper = new Stack<>();
        Stack<int[]> lower = new Stack<>();
        Arrays.sort(trees, (p, q) -> q[0] - p[0] == 0 ? q[1] - p[1] : q[0] - p[0]);
        for (int i = 0; i < trees.length; i++) {
            while (lower.size() >= 2
                    && orientation(lower.get(lower.size() - 2), lower.get(lower.size() - 1), trees[i]) > 0) {
                lower.pop();
            }
            while (upper.size() >= 2
                    && orientation(upper.get(upper.size() - 2), upper.get(upper.size() - 1), trees[i]) < 0) {
                upper.pop();
            }
            lower.push(trees[i]);
            upper.push(trees[i]);
        }
        Set<int[]> res = new HashSet<>(lower);
        res.addAll(upper);
        return res.toArray(new int[res.size()][]);
    }

    private int orientation(int[] p, int[] q, int[] r) {
        return (r[1]-q[1]) * (q[0]-p[0]) - ( (q[1]-p[1]) * (r[0]-q[0]));
    }

    public static void main(String[] args) {
        ErectTheFence erectTheFence = new ErectTheFence();
        System.out.println(Arrays.deepToString(erectTheFence.outerTrees(new int[][]
                {
                        {1, 1},
                        {2, 2},
                        {2, 0},
                        {2, 4},
                        {3, 3},
                        {4, 2}
                })));//Output: [[1,1],[2,0],[3,3],[2,4],[4,2]]

        System.out.println(Arrays.deepToString(erectTheFence.outerTrees(new int[][]
                {
                        {1, 2},
                        {2, 2},
                        {4, 2}
                })));//Output: [[4,2],[2,2],[1,2]]
    }
}
