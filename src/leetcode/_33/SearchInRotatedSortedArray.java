package leetcode._33;

//https://www.youtube.com/watch?v=QdVrY3stDD4
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int start = left;
        left = 0;
        right = nums.length - 1;

        if (target >= nums[start] && target <= nums[right]) {
            left = start;
        } else {
            right = start;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid-1;
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
