package leetcode._268;

import java.util.Arrays;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        //9, 6, 4, 2, 3, 5, 7, 0, 1
        //0, 1, 2, 3, 4, 5, 6, 7, 9
        int left = 0;
        int right = nums.length;
        while (left < right){
                int mid = left + (right-left)/2;
                if(nums[mid] > mid){
                    right = mid;
                }else {
                    left = mid+1;
                }
        }
        return left;
    }

    public static void main(String[] args) {
        MissingNumber m = new MissingNumber();
        int number = m.missingNumber(new int[]{0, 1});
        System.out.println(number);
        System.out.println(m.missingNumber(new int[]{3, 0, 1}
        ));//Output: 2
        System.out.println(m.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));//Output: 8
    }
}
