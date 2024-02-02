package leetcode._540;

public class SingleElementInaSortedArray {
    public int singleNonDuplicate(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo != hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid % 2 == 1) {
                mid -= 1;
            }
            if (nums[mid] != nums[mid + 1]) {
                hi = mid;
            } else {
                lo = mid + 2;
            }
        }
        return nums[lo];
    }


    public static void main(String[] args) {
        SingleElementInaSortedArray s = new SingleElementInaSortedArray();
        System.out.println(s.singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));//Output: 2
        System.out.println(s.singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));//Output: 10
    }
}
