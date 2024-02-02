package main.java.com.leetcode.array._442;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] < 0){
                result.add(index+1);
            }
            nums[index] = -nums[index];
        }
        return result;
    }

    public static void main(String[] args) {
        FindAllDuplicatesInAnArray test = new FindAllDuplicatesInAnArray();
        System.out.println(test.findDuplicates(new int[]{4,3,2,7,8,2,3,1}));//Output: [2,3]
        System.out.println(test.findDuplicates(new int[]{1,1,2}));//Output: [1]
        System.out.println(test.findDuplicates(new int[]{1}));//Output: []
    }
}
