package main.java.com.leetcode._1675;

import java.util.PriorityQueue;

public class MinimizeDeviationInArray {

    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        for (int num : nums) {
            if(num % 2 == 1){
                num *= 2;
            }
            pq.add(-num);
            min = Math.min(min, num);
        }
        while (true){
            int a = -pq.poll();
            res = Math.min(res, a - min);
            if(a % 2 == 1){
                break;
            }
            min = Math.min(min, a / 2);
            pq.add(-a/2);
        }
        return res;
    }

    public static void main(String[] args) {
        MinimizeDeviationInArray m = new MinimizeDeviationInArray();
        System.out.println(m.minimumDeviation(new int[]{1,2,3,4}));//Output: 1
        System.out.println(m.minimumDeviation(new int[]{4,1,5,20,3}));//Output: 3
        System.out.println(m.minimumDeviation(new int[]{2,10,8}));//Output: 3
    }
}
