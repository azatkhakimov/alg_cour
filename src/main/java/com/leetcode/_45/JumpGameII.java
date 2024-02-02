package main.java.com.leetcode._45;

public class JumpGameII {

    public int jump(int[] nums) {
        int farthestJump = 0;
        int currentJump = 0;
        int jumps = 0;
        //2,3,1,1,4
        for (int i = 0; i < nums.length-1; i++) {
            farthestJump = Math.max(farthestJump, i + nums[i]);
            if (i == currentJump) {
                jumps++;
                currentJump = farthestJump;
            }
        }
        return jumps;
    }
    public static void main(String[] args) {
        JumpGameII jg = new JumpGameII();
        System.out.println(jg.jump(new int[]{2,3,1,1,4}));//Output: 2
        System.out.println(jg.jump(new int[]{2,3,0,1,4}));//Output: 2
    }
}
