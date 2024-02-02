package main.java.com.leetcode._974;

public class SubarraySumsDivisibleByK {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int prefixMod = 0;
        int result = 0;

        int[] modGroups = new int[k];
        modGroups[0] = 1;

        for (int num : nums) {
            prefixMod = (prefixMod + num % k + k) % k;
            result += modGroups[prefixMod];
            modGroups[prefixMod]++;
        }
        return result;
    }

    public static void main(String[] args) {
        SubarraySumsDivisibleByK subarray = new SubarraySumsDivisibleByK();
        System.out.println(subarray.subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5));//Output: 7
        System.out.println(subarray.subarraysDivByK(new int[]{5}, 9));//Output: 0
    }
}
