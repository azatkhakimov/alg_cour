package main.java.com.leetcode.array.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        List<int[]> answers = new ArrayList<>();
        int[] temporal = intervals[0];
        answers.add(temporal);
        for (int[] interval : intervals) {
            if(interval[0] <= temporal[1]){
                temporal[1] = Math.max(temporal[1], interval[1]);
            }
            else {
                temporal = interval;
                answers.add(temporal);
            }
        }
        return answers.toArray(new int[answers.size()][2]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new MergeIntervals().merge(new int [][]{{1,3},{2,6},{8,10},{15,18}})));
        System.out.println(Arrays.deepToString(new MergeIntervals().merge(new int[][]{{1,4},{4,5}})));
        System.out.println(Arrays.deepToString(new MergeIntervals().merge(new int[][]{{1,4},{5,6}
})));
    }
}
