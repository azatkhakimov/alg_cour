package leetcode.array._1696;

import java.util.ArrayDeque;
import java.util.Deque;

public class JumpGameVI {
    public int maxResult(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(0);
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[dq.peekFirst()] + nums[i];

            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
            if(i - dq.peekFirst() >= k){
                dq.pollFirst();
            }
        }
        return nums[nums.length-1];
    }
    public static void main(String[] args) {
        JumpGameVI jumpGameVI = new JumpGameVI();
        System.out.println(jumpGameVI.maxResult(new int[]{1,-1,-2,4,-7,3},  2));//Output: 7
        System.out.println(jumpGameVI.maxResult(new int[] {10,-5,-2,4,0,3},  3));//Output: 17
        System.out.println(jumpGameVI.maxResult(new int[]{1,-5,-20,4,-1,3,-6,-3}, 2));//Output: 0
    }
}
