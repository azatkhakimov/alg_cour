package main.java.com.leetcode.array;

public class SearchRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            int mid = left+(right-left)/2;

            if(target == nums[mid]){
                return mid;
            }

            if(nums[left] <= nums[mid]){
                if(nums[left] <= target && target < nums[mid]){
                    right = mid-1;
                }
                else {
                    left = mid+1;
                }
            }
            else {
                if(nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                }
                else {
                    right = mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchRotatedSortedArray searchRotatedSortedArray = new SearchRotatedSortedArray();
        System.out.println(searchRotatedSortedArray.search(new int[]{4,5,6,7,0,1,2}, 0));
    }
}
