package conc;

import java.util.Arrays;

public class FinalTest {
    private static final FinalTest s = new FinalTest();

    public static void main(String[] args) {
        System.out.println(s);


    }

    public static boolean findSumOfThree(int[] nums, int target) {
        Arrays.sort(nums);
        int lo = 1;
        int hi = nums.length - 1;
        for (int num : nums) {
            int val = num + nums[lo] + nums[hi];
            if (val == target) {
                return true;
            } else if (val > target) {
                hi--;
            } else {
                lo++;
            }
        }
        return false;
    }
}
