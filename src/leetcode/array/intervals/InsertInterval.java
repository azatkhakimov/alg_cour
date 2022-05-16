package leetcode.array.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> answers = new ArrayList<>();
        int [] add = newInterval;

        for (int i = 0; i < intervals.length; i++){
            //Not overlap and add to add var appears before current interval to add to result
            if(intervals[i][0] > add[1]){
                answers.add(add);
                add = intervals[i];
            }
            //Has overlap and add appears after current interval, add current to result
            else if(intervals[i][1] >= add[0]){
                add = new int[]{Math.min(intervals[i][0], add[0]),
                                Math.max(intervals[i][1], add[1])};
            }
            else {
                answers.add(intervals[i]);
            }
        }
        answers.add(add);
        return answers.toArray(new int[answers.size()][2]);
     }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new InsertInterval().insert(new int[][]{ {1,3},{6,9}},
                new int[]{2,5})));
    }
}
