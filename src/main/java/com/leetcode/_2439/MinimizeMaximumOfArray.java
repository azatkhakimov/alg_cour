package main.java.com.leetcode._2439;

public class MinimizeMaximumOfArray {
    public int minimizeArrayValue(int[] nums) {
        long answer = 0;
        long prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            answer = Math.max(answer, (prefixSum+i)/(i+1));
        }
        return (int)answer;
    }

    public static void main(String[] args) {
        MinimizeMaximumOfArray m = new MinimizeMaximumOfArray();
        System.out.println(m.minimizeArrayValue(new int[]{3,7,1,6}));//Output: 5
        System.out.println(m.minimizeArrayValue(new int[]{10,1}));//Output: 10
    }
}
