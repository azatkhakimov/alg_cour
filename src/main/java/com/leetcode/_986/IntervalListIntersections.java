package main.java.com.leetcode._986;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> intersections = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < firstList.length && j < secondList.length){
            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);
            if(start <= end){
                intersections.add(new int[]{start, end});
            }

            if(firstList[i][1] < secondList[j][1]){
                i+=1;
            }else {
                j+=1;
            }
        }
        return intersections.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        IntervalListIntersections intersections = new IntervalListIntersections();
        System.out.println(Arrays.deepToString(
                intersections.intervalIntersection(new int[][]{
                                {0, 2},
                                {5, 10},
                                {13, 23},
                                {24, 25}
                        },
                        new int[][]{
                                {1, 5},
                                {8, 12},
                                {15, 24},
                                {25, 26}
                        })
        ));//Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
        System.out.println(Arrays.deepToString(
                intersections.intervalIntersection(new int[][]{
                        {1,3},
                        {5,9}
                },
                        new int[][]{

                        })
        ));//Output: []
    }
}
