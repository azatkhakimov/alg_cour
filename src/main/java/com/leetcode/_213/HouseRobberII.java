package main.java.com.leetcode._213;

public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        int withFirstHouse = rob(nums, 0, nums.length-2);
        int withLastHouse = rob(nums, 1, nums.length-1);
        return Math.max(withFirstHouse, withLastHouse);
    }

    private int rob(int[] nums, int start, int end) {
        if(start == end){
            return nums[start];
        }
        int [] money = new int[nums.length];
        money[start] = nums[start];
        money[start+1] = Math.max(nums[start+1], nums[start]);
        for(int i = start+2; i <= end; i++){
            money[i] = Math.max(money[i-1], money[i-2]+nums[i]);
        }
        return money[end];
    }


    public static void main(String[] args) {
        HouseRobberII houseRobberII = new HouseRobberII();
        System.out.println(houseRobberII.rob(new int[]{2, 3, 2}));//Output: 3
        System.out.println(houseRobberII.rob(new int[]{1, 2, 3, 1}));//Output: 4
        System.out.println(houseRobberII.rob(new int[]{1, 2, 3}));//Output: 3
    }
}

