package leetcode.array._376;

public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int down = 1;
        int up = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down+1;
            }else if(nums[i] < nums[i-1]){
                down = up + 1;
            }
        }
        return Math.max(down, up);
    }
    public static void main(String[] args) {
        WiggleSubsequence wiggleSubsequence = new WiggleSubsequence();
        System.out.println(wiggleSubsequence.wiggleMaxLength(new int[]{1,7,4,9,2,5}));//Output: 6
        System.out.println(wiggleSubsequence.wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8}));//Output: 7
    }
}
