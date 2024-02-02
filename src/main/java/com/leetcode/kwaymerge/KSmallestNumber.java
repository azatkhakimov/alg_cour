package main.java.com.leetcode.kwaymerge;

import java.util.List;
import java.util.PriorityQueue;

public class KSmallestNumber {
    public static int kSmallestNumber(List<List<Integer>> lists, int k) {
        int listLength = lists.size();
        PriorityQueue<int[]> kthSmallest = new PriorityQueue<>();
        for (int i = 0; i < listLength; i++) {
            if(lists.get(i).size() == 0){
                continue;
            }else {
                kthSmallest.offer(new int[]{lists.get(i).get(0), i, 0});
            }
        }

        int numbersChecked = 0;
        int smallestNumber = 0;
        while (!kthSmallest.isEmpty()) {
            int[] smallest = kthSmallest.poll();
            smallestNumber = smallest[0];
            int listIndex = smallest[1];
            int numIndex = smallest[0];
            numbersChecked++;
            if(numbersChecked == k){
                break;
            }
            if(numIndex + 1 < lists.get(smallest[1]).size()){
                kthSmallest.offer(new int[]{lists.get(listIndex).get(numIndex+1), listIndex, numIndex+1});
            }
        }
        return smallestNumber;
    }
}
