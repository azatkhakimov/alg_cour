package main.java.com.leetcode._502;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class IPO {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Project[] projects = new Project[n];
        for (int i = 0; i < n; i++) {
            projects[i] = new Project(capital[i], profits[i]);
        }
        Arrays.sort(projects);
        PriorityQueue<Integer> queue = new PriorityQueue<>(n, Collections.reverseOrder());
        int ptr = 0;
        for (int i = 0; i < k; i++) {
            while (ptr < n && projects[ptr].capital <= w){
                queue.add(projects[ptr++].profit);
            }
            if(queue.isEmpty()){
                break;
            }
            w += queue.poll();
        }
        return w;
    }


    public static void main(String[] args) {
        IPO ipo = new IPO();
        System.out.println(ipo.findMaximizedCapital(
                2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1}
        ));//Output: 4
        System.out.println(ipo.findMaximizedCapital(
                3, 0, new int[]{1, 2, 3}, new int[]{0, 1, 2}
        ));//Output: 6
    }

    private class Project implements Comparable<Project> {
        int capital;
        int profit;

        public Project(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }

        @Override
        public int compareTo(Project o) {
            return capital - o.capital;
        }
    }
}
