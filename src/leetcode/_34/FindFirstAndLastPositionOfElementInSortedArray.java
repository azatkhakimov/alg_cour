package leetcode._34;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = searchFirst(nums, target);
        ans[1] = searchSecond(nums, target);
        return ans;
    }


    private int searchFirst(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int idx = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                idx = mid;
            }
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return idx;
    }

    private int searchSecond(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int idx = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                idx = mid;
            }
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        var f = new FindFirstAndLastPositionOfElementInSortedArray();
        System.out.println(Arrays.toString(f.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));//[3,4]
        System.out.println(Arrays.toString(f.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));//[-1,-1]);
        System.out.println(Arrays.toString(f.searchRange(new int[]{}, 0)));//[-1,-1]);
    }
}
