package main.java.com.leetcode._218;

import java.util.*;

public class TheSkylineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        List<int[]> heights = new ArrayList<>();
        for (int[] building : buildings) {
            heights.add(new int[]{building[0], -building[2]});
            heights.add(new int[]{building[1], building[2]});
        }
        Collections.sort(heights, (a,b)->{
            if(a[0] != b[0]){
                return a[0]-b[0];
            }
            return a[1]-b[1];
        });
        Queue<Integer> queue = new PriorityQueue<>((a,b)->(b-a));
        queue.offer(0);

        int prev = 0;
        for (int[] height : heights) {
            if(height[1] < 0){
                queue.offer(-height[1]);
            }else {
                queue.remove(height[1]);
            }
            int cur = queue.peek();

            if(prev != cur){
                result.add(Arrays.asList(height[0], cur));
                prev = cur;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        TheSkylineProblem theSkylineProblem = new TheSkylineProblem();
        System.out.println(theSkylineProblem.getSkyline(new int[][]{
                {2, 9, 10},
                {3, 7, 15},
                {5, 12, 12},
                {15, 20, 10},
                {19, 24, 8}}
        ));//Output: [[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
        System.out.println(theSkylineProblem.getSkyline(new int[][]{
                {0, 2, 3},
                {2, 5, 3}
        }));//Output: [[0,3],[5,0]]
    }
}
