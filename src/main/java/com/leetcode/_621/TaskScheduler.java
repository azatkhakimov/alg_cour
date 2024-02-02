package main.java.com.leetcode._621;

import java.util.*;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> taskFrequencies = new HashMap<>();


        for (char task : tasks) {
            taskFrequencies.put(task, taskFrequencies.getOrDefault(task, 0)+1);
        }
        List<Map.Entry<Character, Integer>> sortedFreq = new ArrayList<>(taskFrequencies.entrySet());
        Collections.sort(sortedFreq, Map.Entry.comparingByValue());

        int maxFreq = sortedFreq.get(sortedFreq.size()-1).getValue();
        sortedFreq.remove(sortedFreq.size()-1);
        int idleTime = (maxFreq - 1) * n;
        while (!sortedFreq.isEmpty() && idleTime > 0){
            Integer currFreq = sortedFreq.get(sortedFreq.size() - 1).getValue();
            idleTime -= Math.min(maxFreq-1, currFreq);
            sortedFreq.remove(sortedFreq.size()-1);
        }
        idleTime = Math.max(0, idleTime);
        return tasks.length + idleTime;
    }
    public static void main(String[] args) {
        TaskScheduler taskScheduler = new TaskScheduler();
        System.out.println(taskScheduler.leastInterval(new char[]{'A','A','A','B','B','B'}, 2));//Output: 8
        System.out.println(taskScheduler.leastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'}, 2));//Output: 16
    }
}
