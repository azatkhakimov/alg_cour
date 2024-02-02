package main.java.com.leetcode._457;

public class CircularArrayLoop {
    public boolean circularArrayLoop(int[] nums) {
        int slow = 0;
        int fast = 0;
        int size = nums.length;
        for(int i = 1; i <= size; i++){
            int prev = slow;
            slow = nextStep(slow, nums[slow], size);
            if(isNotCycle(nums, prev, slow)){
                slow = i;
                fast = i;
                continue;
            }
            boolean nextIter = false;
            int moves = 2;
            for(int j = 0; j < moves; j++){
                prev = fast;
                fast = nextStep(fast, nums[fast], size);
                if(isNotCycle(nums, prev, fast)){
                    slow = i;
                    fast = i;
                    nextIter = true;
                    break;
                }
            }
            if(nextIter){
                continue;
            }
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    private boolean isNotCycle(int[] nums, int prev, int pointer) {
        return (nums[prev] >= 0 && nums[pointer] < 0) || (Math.abs(nums[pointer] % nums.length) == 0);
    }

    private int nextStep(int pointer, int value, int size) {
        int result = (pointer + value) % size;
        if(result < 0){
            result += size;
        }
        return result;
    }

    public static void main(String[] args) {
        CircularArrayLoop c = new CircularArrayLoop();
        System.out.println(c.circularArrayLoop(new int[]{2,-1,1,2,2}));//Output: true
        System.out.println(c.circularArrayLoop(new int[]{-1,-2,-3,-4,-5,6}));//Output: false
        System.out.println(c.circularArrayLoop(new int[]{1,-1,5,1,4}));//Output: true
    }
}
