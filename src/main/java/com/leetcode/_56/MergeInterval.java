package main.java.com.leetcode._56;

import java.util.ArrayList;
import java.util.List;

public class MergeInterval {
    public List <Interval> mergeIntervals(List<Interval> intervals) {
        List<Interval> output = new ArrayList<>();
        output.add(new Interval(intervals.get(0).getStart(), intervals.get(0).getEnd()));
        for (int i = 0; i < intervals.size(); i++) {
            Interval lastAddedInterval = output.get(output.size()-1);
            int curStart = intervals.get(i).getStart();
            int curEnd = intervals.get(i).getEnd();
            int prevEnd = lastAddedInterval.getEnd();
            if(curStart < prevEnd){
                lastAddedInterval.setEnd(Math.max(curEnd, prevEnd));
            }else {
                output.add(new Interval(curStart, curEnd));
            }
        }
        return output;
    }


    public static void main(String[] args) {

    }


    class Interval{
        int start;
        int end;
        boolean closed;
        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
        public int getStart(){
            return start;
        }

        public int getEnd(){
            return end;
        }
        public void setEnd(int end){
            this.end = end;
        }

        public void setClosed(boolean closed) {
            this.closed = closed;
        }
    }
}
