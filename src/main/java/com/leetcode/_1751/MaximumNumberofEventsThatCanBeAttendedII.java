package main.java.com.leetcode._1751;

import java.util.Arrays;

public class MaximumNumberofEventsThatCanBeAttendedII {

    private int[][] dp;
    private int[] nextIndices;

    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int n = events.length;
        nextIndices = new int[n];
        for (int curIndex = 0; curIndex < n; ++curIndex) {
            nextIndices[curIndex] = bisectRight(events, events[curIndex][1]);
        }

        dp = new int[k + 1][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return dfs(0, k, events);
    }

    private int bisectRight(int[][] events, int target) {
        int left = 0, right = events.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (events[mid][0] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int dfs(int curIndex, int count, int[][] events) {
        if (count == 0 || curIndex == events.length) {
            return 0;
        }
        if (dp[count][curIndex] != -1) {
            return dp[count][curIndex];
        }
        int nextIndex = nextIndices[curIndex];
        dp[count][curIndex] = Math.max(dfs(curIndex + 1, count, events), events[curIndex][2] + dfs(nextIndex, count - 1, events));
        return dp[count][curIndex];
    }

    public static void main(String[] args) {
        var m = new MaximumNumberofEventsThatCanBeAttendedII();
        System.out.println(m.maxValue(new int[][]{{1,2,4},{3,4,3},{2,3,1}}, 2));//Output: 7
        System.out.println(m.maxValue(new int[][]{{1,2,4},{3,4,3},{2,3,10}}, 2));//Output: 10
//        System.out.println(m.maxValue(new int[][]{[1,1,1],[2,2,2],[3,3,3],[4,4,4]}));
    }
}
