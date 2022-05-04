package leetcode.array;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int max = nums[0];
        int min = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tempMax = Math.max(nums[i] * max, Math.max(nums[i] * min, nums[i]));
            min = Math.min(nums[i]*max, Math.min(nums[i]*min, nums[i]));

            max = tempMax;
            result = Math.max(result, max);
        }
        return result;
    }
    public static void main(String[] args) {
        MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
        System.out.println(maximumProductSubarray.maxProduct(new int[]{2,3,-2,4}));
    }
}
