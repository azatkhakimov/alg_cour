package leetcode.math._462;

import java.util.Arrays;

public class MinimumMovesToEqualArrayElementsII {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length-1;
        int count = 0;
        while (i < j) {
            count += nums[j] - nums[i];
            i++;
            j--;
        }
        return count;
    }

    public static void main(String[] args) {
        MinimumMovesToEqualArrayElementsII test = new MinimumMovesToEqualArrayElementsII();
        System.out.println(test.minMoves2(new int[]{1,2,3}));//2
        System.out.println(test.minMoves2(new int[]{1,10,2,9}));//Output: 16
    }
}
