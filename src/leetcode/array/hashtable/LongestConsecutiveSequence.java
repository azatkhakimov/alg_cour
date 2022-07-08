package leetcode.array.hashtable;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int maxCons = 0;
        Set<Integer> numSet = new HashSet<>();
        for(int i = 0; i<nums.length; i++){
            numSet.add(nums[i]);
        }

        for(int i = 0; i < nums.length; i++){
            int currentNum = nums[i];
            int currentSeqLen = 1;
            if(!numSet.contains(currentNum-1)){
                while (numSet.contains(currentNum+1)){
                    currentNum += 1;
                    currentSeqLen  +=1;
                }
                maxCons = Math.max(maxCons, currentSeqLen);
            }
        }

        return maxCons;
    }

    public static void main(String[] args) {
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(new int[]{100,4,200,1,3,2}));//Output: 4

    }
}
