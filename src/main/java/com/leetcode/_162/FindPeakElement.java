package main.java.com.leetcode._162;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while (left < right){
            int mid = left+(right-left)/2;
            if(nums[mid] < nums[mid+1]){
                left = mid+1;
            }else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(new FindPeakElement().findPeakElement(new int[]{1,2,3,1}));
    }
}
