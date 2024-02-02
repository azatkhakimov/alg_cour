package leetcode._33;

//https://www.youtube.com/watch?v=QdVrY3stDD4
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length-1;
        while(lo <= hi){
            int mid = lo+(hi-lo)/2;
            if(target == nums[mid]){
                return mid;
            }
            if(nums[0] < nums[mid]){
                if(nums[0] <= target && target < nums[mid]){
                    hi = mid-1;
                }else{
                    lo = mid+1;
                }
            }else{
                if(nums[mid] < target && target <= nums[nums.length-1]){
                    lo = mid+1;
                }else{
                    hi = mid-1;
                }
            }

        }
        return -1;
    }


    public static void main(String[] args) {
        SearchInRotatedSortedArray array = new SearchInRotatedSortedArray();
        System.out.println(array.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));//Output: 4
        System.out.println(array.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));//Output: -1
        System.out.println(array.search(new int[]{1}, 0));//Output: -1
    }
}
