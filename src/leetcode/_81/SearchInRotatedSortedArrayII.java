package leetcode._81;

public class SearchInRotatedSortedArrayII {

    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while (left <= right){
            int mid = left+(right-left)/2;
            if(nums[mid] == target){
                return true;
            }
            if(isBinarySearchHelps(nums, left, nums[mid])){
                left++;
                continue;
            }

            boolean pivotArray = existsInFirst(nums, left, nums[mid]);
            boolean targetArray = existsInFirst(nums, left, target);
            if(pivotArray ^ targetArray){
                if(pivotArray){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }else {
                if(nums[mid] < target){
                    left = mid + 1;
                }else {
                    right = mid-1;
                }
            }
        }
        return false;
    }

    private boolean existsInFirst(int[] nums, int left, int num) {
        return nums[left] <= num;
    }

    private boolean isBinarySearchHelps(int[] nums, int left, int element) {
        return nums[left] != element;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArrayII sortedArray = new SearchInRotatedSortedArrayII();
        System.out.println(sortedArray.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));//Output: true
        System.out.println(sortedArray.search(new int[]{2,5,6,0,0,1,2}, 3));//Output: false
    }
}
