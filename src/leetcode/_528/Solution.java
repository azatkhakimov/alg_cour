package leetcode._528;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution {
    private int[] runningSums;
    private int totalSum;

    public Solution(int[] w) {
        runningSums = new int[w.length];
        int runningSum = 0;
        for (int i = 0; i < w.length; i++) {
            runningSum += w[i];
            runningSums[i]= runningSum;
        }
        totalSum = runningSum;
    }

    public int pickIndex() {
        Random random = new Random();
        int target = random.nextInt(totalSum) + 1;
        int lo = 0;
        int hi = runningSums.length;
        while (lo < hi) {
            int mid = lo + (hi-lo)/2;
            if(target > runningSums[mid]){
                lo = mid+1;
            }else {
                hi = mid;
            }
        }
        return lo;
    }


}
