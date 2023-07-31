package leetcode._486;

public class PredicttheWinner {

    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        return maxDiff(nums, 0, n-1, n) >= 0;
    }

    private int maxDiff(int[] nums, int left, int right, int n) {
        if(left == right){
            return nums[left];
        }
        int scoreLeft = nums[left] - maxDiff(nums, left+1, right, n);
        int scoreRight = nums[right] - maxDiff(nums, left, right-1, n);

        return Math.max(scoreLeft, scoreRight);
    }

    public static void main(String[] args) {
        var p = new PredicttheWinner();
        System.out.println(p.PredictTheWinner(new int[]{1,5,2}));//Output: false
        System.out.println(p.PredictTheWinner(new int[]{1,5,233,7}));//Output: true
    }
}
