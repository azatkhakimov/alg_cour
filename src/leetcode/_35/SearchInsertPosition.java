package leetcode._35;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length-1;
        while (lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] > target){
                hi = mid-1;
            }else {
                lo = mid+1;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        SearchInsertPosition s = new SearchInsertPosition();
        System.out.println(s.searchInsert(new int[]{1,3,5,6}, 5));//Output: 2
        System.out.println(s.searchInsert(new int[]{1,3,5,6}, 2));//Output: 1
        System.out.println(s.searchInsert(new int[]{1,3,5,6}, 7));//Output: 4
    }
}
