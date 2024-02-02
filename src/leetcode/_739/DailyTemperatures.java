package leetcode._739;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[temperatures.length];
        for (int currDay = 0; currDay < temperatures.length; currDay++) {
            int currTemp = temperatures[currDay];
            while (!stack.isEmpty() && temperatures[stack.peek()] < currTemp){
                Integer prevDay = stack.pop();
                answer[prevDay] = currDay-prevDay;
            }
            stack.push(currDay);
        }
        return answer;
    }

    public static void main(String[] args) {
        var d = new DailyTemperatures();
        System.out.println(Arrays.toString(d.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})));//Output: [1,1,4,2,1,1,0,0]
        System.out.println(Arrays.toString(d.dailyTemperatures(new int[]{30,40,50,60})));//Output: [1,1,1,0]
        System.out.println(Arrays.toString(d.dailyTemperatures(new int[]{30,60,90})));//Output: [1,1,0]
    }
}
