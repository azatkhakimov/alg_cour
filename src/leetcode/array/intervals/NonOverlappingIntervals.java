package leetcode.array.intervals;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int erasedCount = 0;
        int [] temp = intervals[0];
        for(int i = 1; i<intervals.length; i++){
            if(temp[1] > intervals[i][0]){
                erasedCount++;
            }else{
                temp = intervals[i];
            }
        }
        return erasedCount;
    }

    public static void main(String[] args) {
        System.out.println(new NonOverlappingIntervals().eraseOverlapIntervals(new int[][]{{1, 2},
                {2, 3},
                {3, 4},
                {1, 3}}));
        System.out.println(new NonOverlappingIntervals().eraseOverlapIntervals(new int[][]{{1,2},{1,2},{1,2}}));
    }
}
