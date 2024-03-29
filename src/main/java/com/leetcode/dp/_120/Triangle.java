package main.java.com.leetcode.dp._120;

import java.util.Arrays;
import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()+1];
        for (int i = triangle.size()-1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j+1])+triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        System.out.println(triangle.minimumTotal(Arrays.asList(Arrays.asList(2),
                Arrays.asList(3,4), Arrays.asList(6,5,7), Arrays.asList(4,1,8,3))));
    }
}
