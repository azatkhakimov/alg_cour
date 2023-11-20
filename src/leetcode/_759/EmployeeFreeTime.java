package leetcode._759;

import java.util.*;

public class EmployeeFreeTime {

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < schedule.size(); i++) {
            List<Interval> employeeSchedule = schedule.get(i);
            Interval interval = employeeSchedule.get(0);
            heap.offer(new int[]{interval.start, i, 0});
        }

        List<Interval> ans = new ArrayList<>();
        int previous = schedule.get(heap.peek()[1]).get(heap.peek()[2]).start;

        while (!heap.isEmpty()){
            int[] tuple = heap.poll();
            int i = tuple[1];
            int j = tuple[2];

            Interval interval = schedule.get(i).get(j);
            if(interval.start > previous){
                ans.add(new Interval(previous, interval.start));
            }

            previous = Math.max(previous, interval.end);

            if(j + 1 < schedule.get(i).size()){
                Interval nextInterval = schedule.get(i).get(j+1);
                heap.offer(new int[]{nextInterval.start, i, j+1});
            }
        }
        return ans;
    }


    public static void main(String[] args) {

    }

    class Interval{
        int start;
        int end;
        boolean closed;
        public Interval(int start, int end)
        {
            this.start = start;
            this.end = end;
            this.closed = true; // by default, the interval is closed
        }

        // set the flag for closed/open
        public void setClosed(boolean closed)
        {
            this.closed = closed;
        }

    }
}
