package main.java.com.leetcode._2444;

public class CountSubarraysWithFixedBounds {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0;

        int minPosition = -1;
        int maxPosition = -1;
        int leftBound = -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < minK || nums[i] > maxK){
                leftBound = i;
            }
            if(nums[i] == minK){
                minPosition = i;
            }
            if(nums[i] == maxK){
                maxPosition = i;
            }
            ans += Math.max(0, Math.min(maxPosition, minPosition)- leftBound);
        }

        return ans;
    }

    public static void main(String[] args) {
        CountSubarraysWithFixedBounds c = new CountSubarraysWithFixedBounds();
        System.out.println(c.countSubarrays(new int[]{1, 3, 5, 2, 7, 5}, 1, 5));//Output: 2
        System.out.println(c.countSubarrays(new int[]{1,1,1,1}, 1 ,1 ));//Output: 10
    }
}
