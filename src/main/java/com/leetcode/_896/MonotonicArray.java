package main.java.com.leetcode._896;

public class MonotonicArray {


    public boolean isMonotonic(int[] nums) {
        boolean increase = true;
        boolean decrease = true;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i-1]){
                decrease = false;
            } else if (nums[i] < nums[i-1]) {
                increase = false;
            }

            if(!increase && !decrease){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        var m = new MonotonicArray();
        System.out.println(m.isMonotonic(new int[]{1,2,2,3}));//Output: true
        System.out.println(m.isMonotonic(new int[]{6,5,4,4}));//Output: true
        System.out.println(m.isMonotonic(new int[]{1,3,2}));//Output: false
    }
}
