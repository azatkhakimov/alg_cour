package leetcode._540;

public class SingleElementInaSortedArray {
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while (left < right){
            int mid = left + (right-left)/2;
            boolean even = (right-mid) % 2 == 0;
            if(nums[mid] == nums[mid-1]){
                if(even){
                    right = mid-2;
                }else {
                    left = mid + 1;
                }
            } else if (nums[mid] == nums[mid+1]) {
                if(even){
                    left = mid+2;
                }else {
                    right = mid-1;
                }
            }
        }
        return nums[left];
    }


    public static void main(String[] args) {
        SingleElementInaSortedArray s = new SingleElementInaSortedArray();
        System.out.println(s.singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));//Output: 2
        System.out.println(s.singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));//Output: 10
    }
}
