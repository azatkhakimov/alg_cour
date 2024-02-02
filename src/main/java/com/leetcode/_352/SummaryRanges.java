package main.java.com.leetcode._352;

import java.util.Map;
import java.util.TreeMap;

class SummaryRanges {
    private TreeMap<Integer, Integer> intervals;
    public SummaryRanges() {
        intervals = new TreeMap<>();
    }

    public void addNum(int value) {
        Map.Entry<Integer, Integer> smallEntry = intervals.floorEntry(value);
        int left = value;
        int right = value;
        if(smallEntry != null){
            int previous = smallEntry.getValue();
            if(previous >= value){
                return;
            }
            if(previous == value -1){
                left = smallEntry.getKey();
            }
        }
        Map.Entry<Integer, Integer> maxEntry = intervals.higherEntry(value);
        if(maxEntry != null && maxEntry.getKey() == value+1){
            right = maxEntry.getValue();
            intervals.remove(value+1);
        }
        intervals.put(left, right);
    }

    public int[][] getIntervals() {
        int[][] answer = new int[intervals.size()][2];
        int ind = 0;
        for (Map.Entry<Integer, Integer> entry : intervals.entrySet()) {
            answer[ind][0] = entry.getKey();
            answer[ind++][1] = entry.getValue();
        }
        return answer;
    }
}
