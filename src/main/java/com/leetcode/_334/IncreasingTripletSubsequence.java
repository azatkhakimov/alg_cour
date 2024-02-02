package main.java.com.leetcode._334;

public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int i = Integer.MAX_VALUE;
        int j = Integer.MAX_VALUE;
        for (int index = 0; index < nums.length; index++) {
            if(nums[index] <= i){
                i = nums[index];
            }else if(nums[index] <= j){
                j = nums[index];
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IncreasingTripletSubsequence increasingTripletSubsequence = new IncreasingTripletSubsequence();
        System.out.println(increasingTripletSubsequence.increasingTriplet(new int[]{1,2,3,4,5}));//Output: true
        System.out.println(increasingTripletSubsequence.increasingTriplet(new int[]{5,4,3,2,1}));//Output: false
        System.out.println(increasingTripletSubsequence.increasingTriplet(new int[]{2,1,5,0,4,6}));//Output: true
    }
}
