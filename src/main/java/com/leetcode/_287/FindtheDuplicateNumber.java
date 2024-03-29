package main.java.com.leetcode._287;

public class FindtheDuplicateNumber {


    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        while (true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast){
                break;
            }
        }

        slow = nums[0];
        while (slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;

    }

    public static void main(String[] args) {
        var f = new FindtheDuplicateNumber();
        System.out.println(f.findDuplicate(new int[]{1,3,4,2,2}));//Output: 2
        System.out.println(f.findDuplicate(new int[]{3,1,3,4,2}));//Output: 3
    }
}
