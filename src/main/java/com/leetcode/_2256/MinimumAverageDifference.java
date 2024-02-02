package main.java.com.leetcode._2256;

public class MinimumAverageDifference {

    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        int ans = -1;
        int minAvgDiff = Integer.MAX_VALUE;
        long currPrefSum = 0;

        long totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
        }
        for (int i = 0; i < n; i++) {
            currPrefSum += nums[i];

            long leftPartAvg = currPrefSum;
            leftPartAvg /= (i+1);
            long rightPartAvg = totalSum - currPrefSum;
            if(i != n-1){
                rightPartAvg /= (n-i-1);
            }
            int curDiff = (int)Math.abs(leftPartAvg-rightPartAvg);
            if(curDiff < minAvgDiff){
                minAvgDiff = curDiff;
                ans = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MinimumAverageDifference difference = new MinimumAverageDifference();
        System.out.println(difference.minimumAverageDifference(new int[]{2,5,3,9,5,3}));//Output: 3
        System.out.println(difference.minimumAverageDifference(new int[]{0}));//Output: 0
    }
}
