package leetcode._55;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int lastGoodIndPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if(i+nums[i] >= lastGoodIndPos){
                lastGoodIndPos = i;
            }
        }
        return lastGoodIndPos == 0;
    }

    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        System.out.println(jumpGame.canJump(new int[]{2,3,1,1,4}));//true;
        System.out.println(jumpGame.canJump(new int[]{3,2,1,0,4}));//false
    }
}
