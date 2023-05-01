package leetcode._45;

public class JumpGameII {

    public int jump(int[] nums) {
        int answer = 0;
        int n = nums.length;
        int curEnd = 0;
        int curFar = 0;
        for (int i = 0; i < n - 1; i++) {
            curFar = Math.max(curFar, i + nums[i]);
            if(i == curEnd){
                answer++;
                curEnd = curFar;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        JumpGameII jg = new JumpGameII();
        System.out.println(jg.jump(new int[]{2,3,1,1,4}));//Output: 2
        System.out.println(jg.jump(new int[]{2,3,0,1,4}));//Output: 2
    }
}
