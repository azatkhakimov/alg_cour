package main.java.com.leetcode._1535;

import java.util.LinkedList;
import java.util.Queue;

public class FindtheWinnerofanArrayGame {

    public int getWinner(int[] arr, int k) {
        int maxElement = arr[0];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < arr.length; i++) {
            maxElement = Math.max(maxElement, arr[i]);
            queue.offer(arr[i]);
        }
        int curr = arr[0];
        int winStreak = 0;
        while (!queue.isEmpty()) {
            int opponent = queue.poll();
            if(curr > opponent){
                queue.offer(opponent);
                winStreak++;
            }else {
                queue.offer(curr);
                curr = opponent;
                winStreak = 1;
            }

            if(winStreak == k || curr == maxElement){
                return curr;
            }
        }
        return  - 1;

    }


    public static void main(String[] args) {
        var f = new FindtheWinnerofanArrayGame();
        System.out.println(f.getWinner(new int[]{2, 1, 3, 5, 4, 6, 7}, 2));//Output: 5
        System.out.println(f.getWinner(new int[]{3, 2, 1}, 10));//Output: 3
    }
}
