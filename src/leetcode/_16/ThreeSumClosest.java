package leetcode._16;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[nums.length-1];
        Arrays.sort(nums);

        for (int i = 0; i < nums.length-2; i++) {
            int pointerA = i+1;
            int pointerB = nums.length-1;
            while (pointerA < pointerB){
                int curSum = nums[i] + nums[pointerA] + nums[pointerB];
                if(curSum > target){
                    pointerB -= 1;
                }else {
                    pointerA += 1;
                }

                if(Math.abs(curSum-target) < Math.abs(result - target)){
                    result = curSum;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        System.out.println(threeSumClosest.threeSumClosest(new int[]{-1,2,1,-4}, 1));//Output: 2
        System.out.println(threeSumClosest.threeSumClosest(new int[]{0,0,0}, 1));//Output: 0
    }
}
