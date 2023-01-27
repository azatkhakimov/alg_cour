package leetcode._239;

import java.util.*;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0){
            return new int[0];
        }
        if(k > nums.length){
            k = nums.length;
        }
        int[] ans = new int[nums.length-k+1];
        Deque<Integer> currentWindow = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            clean(i, currentWindow, nums);
            currentWindow.add(i);
        }
        ans[0] = nums[currentWindow.getFirst()];
        for (int i = k; i < nums.length; i++) {
            clean(i, currentWindow, nums);
            if(!currentWindow.isEmpty() && currentWindow.getFirst() <= (i-k)){
                currentWindow.removeFirst();
            }
            currentWindow.add(i);
            ans[i-k+1] = nums[currentWindow.getFirst()];
        }
        return ans;
    }

    private void clean(int i, Deque<Integer> currentWindow, int[] nums) {
        while (currentWindow.size() != 0 && nums[i] >= nums[currentWindow.getLast()]){
            currentWindow.removeLast();
        }
    }

    public static void main(String[] args) {
        SlidingWindowMaximum s = new SlidingWindowMaximum();
        System.out.println(
                Arrays.toString(s.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},
                        3)));//Output: [3,3,5,5,6,7]
        System.out.println(
                Arrays.toString(s.maxSlidingWindow(new int[]{1},  1))
        );//Output: [1]
    }
}
