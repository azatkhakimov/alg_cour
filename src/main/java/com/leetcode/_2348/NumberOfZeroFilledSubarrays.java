package main.java.com.leetcode._2348;

public class NumberOfZeroFilledSubarrays {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        long numSubArray = 0;
        for (int num : nums) {
            if(num == 0){
                numSubArray++;
            }else {
                numSubArray = 0;
            }
            ans += numSubArray;
        }
        return ans;
    }

    public static void main(String[] args) {
        NumberOfZeroFilledSubarrays n = new NumberOfZeroFilledSubarrays();
        System.out.println(n.zeroFilledSubarray(new int[]{1, 3, 0, 0, 2, 0, 0, 4}));//Output: 6
        System.out.println(n.zeroFilledSubarray(new int[]{0, 0, 0, 2, 0, 0}));//Output: 9
        System.out.println(n.zeroFilledSubarray(new int[]{2, 10, 2019}));//Output: 0
    }
}
