package leetcode._81;

public class SearchInRotatedSortedArrayII {

    public boolean search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length-1;
        while (lo < hi){
            int mid = lo+(hi-lo)/2;
            if(nums[mid] == target){
                return true;
            }
            if(nums[0] < nums[mid]){
                if(nums[0] <= target && target < nums[mid]){
                    hi = mid;
                }else {
                    lo = mid-1;
                }
            }else {
                if(target <= nums[nums.length-1] && target > nums[mid]){
                    lo = mid+1;
                }else {
                    hi = mid;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        SearchInRotatedSortedArrayII sortedArray = new SearchInRotatedSortedArrayII();
        System.out.println(sortedArray.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));//Output: true
        System.out.println(sortedArray.search(new int[]{2,5,6,0,0,1,2}, 3));//Output: false
    }
}
