package leetcode.dp._746;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int stepOne = 0;
        int stepTwo = 0;
        for (int i = cost.length - 1; i >= 0; i--) {
            int currentStep = cost[i] + Math.min(stepOne, stepTwo);
            stepOne = stepTwo;
            stepTwo = currentStep;
        }
        return Math.min(stepOne, stepTwo);
    }
    public static void main(String[] args) {
        MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();
        System.out.println(minCostClimbingStairs.minCostClimbingStairs(new int[]{10,15,20}));//Output: 15
        System.out.println(minCostClimbingStairs.minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));//Output: 6
    }
}
