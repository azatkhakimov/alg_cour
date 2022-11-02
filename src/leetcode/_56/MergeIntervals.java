package leetcode._56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        List<int[]> result = new ArrayList<>();
        int[] temp = intervals[0];
        result.add(temp);
        for (int[] interval : intervals) {
            if (interval[0] <= temp[1]) {
                temp[1] = Math.max(temp[1], interval[1]);
            } else {
                temp = interval;
                result.add(temp);
            }
        }
        return result.toArray(new int[result.size()][2]);
    }

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        System.out.println(Arrays.deepToString(
                mergeIntervals.merge(new int[][]{
                        {1, 3},
                        {2, 6},
                        {8, 10},
                        {15, 18}
                })
        ));//Output: [[1,6],[8,10],[15,18]]
        System.out.println(Arrays.deepToString(
                mergeIntervals.merge(new int[][]{
                        {1,4},
                        {4,5}
                })
        ));//Output: [[1,5]]
    }
}
