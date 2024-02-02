package main.java.com.leetcode._55;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int targetNumIdx = nums.length-1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if(targetNumIdx <= nums[i]+i){
                targetNumIdx = i;
            }
        }
        return targetNumIdx == 0;
    }

    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        System.out.println(jumpGame.canJump(new int[]{2,3,1,1,4}));//true;
        System.out.println(jumpGame.canJump(new int[]{3,2,1,0,4}));//false
    }
}
