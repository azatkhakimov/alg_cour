package leetcode.sorting._34;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0]= searchStartingIndex(nums, target);
        result[1] = searchEndingIndex(nums, target);
        return result;
    }

    private int searchEndingIndex(int[] nums, int target) {
        int index = -1;
        int start = 0;
        int end = nums.length-1;
        while(start <= end){
            int mid = start+(end-start)/2;
            if(nums[mid] <= target){
                start = mid+1;
            }else {
                end = mid-1;
            }
            if(nums[mid] == target){
                index = mid;
            }
        }
        return index;
    }

    private int searchStartingIndex(int[] nums, int target) {
        int index = -1;
        int start = 0;
        int end = nums.length-1;
        while(start <= end){
            int mid = start+(end-start)/2;
            if(nums[mid] >= target){
                end = mid-1;
            }else {
                start = mid+1;
            }
            if(nums[mid] == target){
                index = mid;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray test = new FindFirstAndLastPositionOfElementInSortedArray();
        System.out.println(Arrays.toString(test.searchRange( new int[]{5,7,7,8,8,10},  8)));
        System.out.println(Arrays.toString(test.searchRange(new int[] {5,7,7,8,8,10},  6)));
    }

}
