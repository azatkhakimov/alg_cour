package leetcode._2244;

import java.util.HashMap;
import java.util.Map;

public class MinimumRoundsToCompleteAllTasks {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int task : tasks) {
            freq.put(task, freq.getOrDefault(task, 0)+1);
        }

        int minRounds = 0;

        for (Integer count : freq.values()) {
            if(count == 1){
                return -1;
            }

            if(count % 3 == 0){
                minRounds += count / 3;
            }else {
                minRounds += count / 3 + 1;
            }
        }
        return minRounds;
    }

    public static void main(String[] args) {
        MinimumRoundsToCompleteAllTasks tasks = new MinimumRoundsToCompleteAllTasks();
        System.out.println(tasks.minimumRounds(new int[]{2,2,3,3,2,4,4,4,4,4}));//Output: 4
        System.out.println(tasks.minimumRounds(new int[]{2,3,3}));//Output: -1
    }
}
