package main.java.com.leetcode._1498.binary_search;

import java.util.Arrays;

//*
// Let nnn be the length of the input string s.
//
//    Time complexity: O(n⋅log⁡n)O(n\cdot\log n)O(n⋅logn)
//        We sort nums, which takes O(n⋅log⁡n)O(n \cdot\log n)O(n⋅logn) time.
//        In Java, we initialize an array power and precompute the value of 2 to the power of each value. It takes O(n)O(n)O(n) time.
//        We iterate over nums, for each left index left, we use binary search to locate the rightmost element that is smaller than or equal to target - nums[left].
//        Binary search over array of size nnn takes O(log⁡n)O(\log n)O(logn) on average.
//        To sum up, the overall time complexity is O(n⋅log⁡n)O(n\cdot\log n)O(n⋅logn).
//
//    Space complexity: O(n)O(n)O(n) or O(1)O(1)O(1).
//        In Java, we initialize an array power and precompute the value of 2 to the power of each value. It takes O(n)O(n)O(n) space.
//        During the iterate over left, we only need to compute right and update answer, both take constant space.
//        Therefore, the space complexity is O(n)O(n)O(n) for Java and O(1)O(1)O(1) for python.
// *//
public class NumberofSubsequencesThatSatisfytheGivenSumCondition {

    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        int mod = 1_000_000_007;
        Arrays.sort(nums);

        int[] power = new int[n];
        power[0] = 1;
        for (int i = 1; i < n; ++i) {
            power[i] = (power[i - 1] * 2) % mod;
        }

        int answer = 0;
        for (int left = 0; left < n; left++) {
            int right = binarySearchRightmost(nums, target - nums[left])- 1;
            if (right >= left) {
                answer += power[right - left];
                answer %= mod;
            }
        }
        return answer;

    }

    private int binarySearchRightmost(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        var n = new NumberofSubsequencesThatSatisfytheGivenSumCondition();
        System.out.println(n.numSubseq(new int[]{3, 5, 6, 7}, 9));//Output: 4
        System.out.println(n.numSubseq(new int[]{3, 3, 6, 8}, 10));//Output: 6
        System.out.println(n.numSubseq(new int[]{2, 3, 3, 4, 6, 7}, 12));//Output: 61
        System.out.println(n.numSubseq(new int[]{3,5,6,6,9,10,12,14}, 17));
    }
}
