package main.java.com.leetcode.array.sorting._75;

public class SortColors {
    public void sortColors(int[] nums) {
        int lt = 0;
        int i = 0;
        int gt = nums.length-1;
        while (i<=gt){
            if(nums[i]==0){
                swap(nums, lt++, i++);
            }else if(nums[i] == 2){
                swap(nums, i, gt--);
            }else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int i1) {
        int temp = nums[i];
        nums[i] = nums[i1];
        nums[i1] = temp;
    }

    public static void main(String[] args) {

    }
}
