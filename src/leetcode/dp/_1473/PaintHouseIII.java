package leetcode.dp._1473;

import java.util.Arrays;

public class PaintHouseIII {
    private static final int MAX_COST = 1000001;

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int [][][] memo = new int[m][target+1][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= target; j++) {
                Arrays.fill(memo[i][j], MAX_COST);
            }
        }

        for (int color = 1; color <= n; color++) {
            if(houses[0] == color){
                memo[0][1][color-1] = 0;
            } else if (houses[0] == 0) {
                memo[0][1][color-1] = cost[0][color-1];
            }
        }

        for (int house = 1; house < m; house++) {
            for(int neighborhoods = 1; neighborhoods <= Math.min(target, house+1); neighborhoods++){
                for (int color = 1; color <= n; color++) {
                    if(houses[house] != 0 && color != houses[house]){
                        continue;
                    }

                    int currCost = MAX_COST;
                    for (int prevColor = 1; prevColor <= n; prevColor++) {
                        if(prevColor != color){
                            currCost  = Math.min(currCost, memo[house-1][neighborhoods-1][prevColor-1]);
                        }else {
                            currCost = Math.min(currCost, memo[house-1][neighborhoods][color-1]);
                        }
                    }

                    int costToPaint = houses[house] != 0 ? 0 : cost[house][color-1];
                    memo[house][neighborhoods][color-1] = currCost+costToPaint;
                }

            }
        }
        int minCost = MAX_COST;
        for (int color = 1; color <= n; color++) {
            minCost = Math.min(minCost, memo[m-1][target][color-1]);
        }

        return minCost == MAX_COST ? -1 : minCost;
    }

    public static void main(String[] args) {
        PaintHouseIII paintHouseIII = new PaintHouseIII();
        System.out.println(paintHouseIII.minCost(
                new int[]{0,0,0,0,0}, new int[][]{{1,10},{10,1},{10,1},{1,10},{5,1}}, 5, 2,  3));//Output: 9
        System.out.println(paintHouseIII.minCost(
                new int[]{0,2,1,2,0}, new int[][]{{1,10},{10,1},{10,1},{1,10},{5,1}},  5,  2,  3
        ));//Output: 11
        System.out.println(paintHouseIII.minCost(
                new int[] {3,1,2,3}, new int[][] {{1,1,1},{1,1,1},{1,1,1},{1,1,1}},  4,  3, 3));//Output: -1
    }
}
