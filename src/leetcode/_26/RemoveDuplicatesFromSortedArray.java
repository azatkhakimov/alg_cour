package leetcode._26;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int idx = 1;
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] != nums[i+1]){
                nums[idx++] = nums[i];
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray duplicates = new RemoveDuplicatesFromSortedArray();
        System.out.println(duplicates.removeDuplicates(new int[]{1,1,2}));//Output: 2, nums = [1,2,_]
        System.out.println(duplicates.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));//Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
    }
}
