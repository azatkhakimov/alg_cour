package leetcode._1235;

import java.util.*;

public class MaximumProfitInJobScheduling {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[1]));
        TreeMap<Integer, Integer> dp = new TreeMap<>();
        dp.put(0,0);
        for (int[] job : jobs) {
            int cur = dp.floorEntry(job[0]).getValue() + job[2];
            if(cur > dp.lastEntry().getValue()){
                dp.put(job[1], cur);
            }
        }
        return dp.lastEntry().getValue();
    }

    public static void main(String[] args) {
        MaximumProfitInJobScheduling profit = new MaximumProfitInJobScheduling();
        System.out.println(profit.jobScheduling(new int[]{1,2,3,3}, new int[]{3,4,5,6}, new int[]{50,10,40,70}));//Output: 120
        System.out.println(profit.jobScheduling(new int[]{1,2,3,4,6}, new int[]{3,5,10,6,9}, new int[]{20,20,100,70,60}));//Output: 150
        System.out.println(profit.jobScheduling(new int[]{1,1,1}, new int[]{2,3,4},  new int[]{5,6,4}));//Output: 6
    }
}
