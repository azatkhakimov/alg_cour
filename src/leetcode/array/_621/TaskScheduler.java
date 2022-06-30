package leetcode.array._621;

import java.util.Arrays;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] taskFreq = new int[26];
        for (char task : tasks) {
            taskFreq[task-'A']++;
        }
        Arrays.sort(taskFreq);
        int maxValue = taskFreq[25]-1;
        int idleSlots = maxValue*n;
        for (int i = 24; i >= 0; i--) {
            idleSlots -= Math.min(taskFreq[i], maxValue);
        }

        return idleSlots > 0 ? idleSlots + tasks.length : tasks.length;
    }
    public static void main(String[] args) {
        TaskScheduler taskScheduler = new TaskScheduler();
        System.out.println(taskScheduler.leastInterval(new char[]{'A','A','A','B','B','B'}, 2));//Output: 8
        System.out.println(taskScheduler.leastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'}, 2));//Output: 16
    }
}
