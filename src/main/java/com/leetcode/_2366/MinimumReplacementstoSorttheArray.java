package main.java.com.leetcode._2366;

public class MinimumReplacementstoSorttheArray {


    public long minimumReplacement(int[] nums) {
        long answer = 0;
        int n = nums.length;
        for (int i = n-2; i >= 0; i--) {
            if(nums[i] <= nums[i+1]){
                continue;
            }

            long numElements = (long) (nums[i]+nums[i+1]-1)/(long) nums[i+1];
            answer += numElements - 1;
            nums[i] = nums[i]/(int)numElements;
        }

        return answer;
    }

    public static void main(String[] args) {
        var m = new MinimumReplacementstoSorttheArray();
        System.out.println(m.minimumReplacement(new int[]{3,9,3}));//Output: 2
        System.out.println(m.minimumReplacement(new int[]{1,2,3,4,5}));//Output: 0
    }
}
