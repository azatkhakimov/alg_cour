package main.java.com.leetcode._985;

import java.util.Arrays;

public class SumOfEvenNumbersAfterQueries {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int s = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                s += num;
            }
        }
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int val = queries[i][0];
            int index = queries[i][1];
            if (nums[index] % 2 == 0) {
                s -= nums[index];
            }
            nums[index] += val;
            if (nums[index] % 2 == 0) {
                s += nums[index];
            }
            answer[i] = s;
        }
        return answer;
    }

    public static void main(String[] args) {
        SumOfEvenNumbersAfterQueries sumOfEvenNumbersAfterQueries = new SumOfEvenNumbersAfterQueries();
        System.out.println(Arrays.toString(sumOfEvenNumbersAfterQueries.sumEvenAfterQueries(
                new int[]{1, 2, 3, 4},
                new int[][]{{1, 0}, {-3, 1}, {-4, 0}, {2, 3}}
        )));//Output: [8,6,2,4]
        System.out.println(Arrays.toString(sumOfEvenNumbersAfterQueries.sumEvenAfterQueries(
                new int[]{1},
                new int[][]{{4, 0}}
        )));//Output: [0]
    }
}
