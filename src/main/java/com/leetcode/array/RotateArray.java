package main.java.com.leetcode.array;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        k %= nums.length;
        System.out.println(k);
        reverse(0, nums.length-1, nums);
        reverse(0, k-1, nums);
        reverse(k, nums.length-1, nums);
    }

    public void reverse(int start, int end, int[] nums) {
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

    }
//    public void rotate(int[] nums, int k) {
//        int n = nums.length - 1;
//        int j = 0;
//        while (n >= nums.length - k) {
//            int rotatedValue = nums[n+j];
//            for (int i = nums.length - 1; i > 0; i--) {
//                nums[i] = nums[i - 1];
//            }
//            nums[0] = rotatedValue;
//            n--;
//            j++;
//        }
//        System.out.println(Arrays.toString(nums));
//    }

    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        rotateArray.rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        rotateArray.rotate(new int[]{-1,-100,3,99},2);
    }
}
