package leetcode._352;

import java.util.Arrays;

public class DataStreamAsDisjointIntervals {

    public static void main(String[] args) {
        SummaryRanges summaryRanges = new SummaryRanges();
        summaryRanges.addNum(1);      // arr = [1]
        System.out.println(Arrays.deepToString(summaryRanges.getIntervals())); // return [[1, 1]]
        summaryRanges.addNum(3);      // arr = [1, 3]
        System.out.println(Arrays.deepToString(summaryRanges.getIntervals())); // return [[1, 1], [3, 3]]
        summaryRanges.addNum(7);      // arr = [1, 3, 7]
        System.out.println(Arrays.deepToString(summaryRanges.getIntervals())); // return [[1, 1], [3, 3], [7, 7]]
        summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
        System.out.println(Arrays.deepToString(summaryRanges.getIntervals())); // return [[1, 3], [7, 7]]
        summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
        System.out.println(Arrays.deepToString(summaryRanges.getIntervals())); // return [[1, 3], [6, 7]]
    }
}
