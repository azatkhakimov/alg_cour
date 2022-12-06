package leetcode._907;

import java.util.Stack;

public class SumOfSubarrayMinimums {
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] dp = new int[arr.length+1];
        stack.push(-1);
        int result = 0;
        int MOD = (int) (1e9+7);
        for (int i = 0; i < arr.length; i++) {
            while(stack.peek() != -1 && arr[i] < arr[stack.peek()]){
                stack.pop();
            }
            dp[i+1] = (dp[stack.peek()+1]+(i-stack.peek()) * arr[i]) % MOD;
            stack.push(i);
            result += dp[i+1];
            result %= MOD;
        }
        return result;
    }

    public static void main(String[] args) {
        SumOfSubarrayMinimums sum = new SumOfSubarrayMinimums();
        System.out.println(sum.sumSubarrayMins(new int[]{3,1,2,4}));//Output: 17
        System.out.println(sum.sumSubarrayMins(new int[]{11,81,94,43,3}));//Output: 444
    }
}
