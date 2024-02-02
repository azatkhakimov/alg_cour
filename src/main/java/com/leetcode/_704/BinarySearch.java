package main.java.com.leetcode._704;

public class BinarySearch {

    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length-1;
        while (lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(nums[mid] == target){
                return mid;
            } else if (nums[mid] > target) {
                hi = mid-1;
            }else {
                lo = mid+1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        BinarySearch b = new BinarySearch();
        System.out.println(b.search(new int[]{-1, 0, 3, 5, 9, 12}, 9));//Output: 4
        System.out.println(b.search(new int[]{-1,0,3,5,9,12}, 2));//Output: -1
    }
}
