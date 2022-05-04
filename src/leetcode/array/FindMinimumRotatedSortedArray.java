package leetcode.array;

public class FindMinimumRotatedSortedArray {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        //Check if there is rotation
        if (nums[right] > nums[left]) {
            return nums[0];
        }

        while (right >= left) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindMinimumRotatedSortedArray test = new FindMinimumRotatedSortedArray();
        System.out.println(test.findMin(new int[]{4,5,6,7,2,3}));
    }
}
