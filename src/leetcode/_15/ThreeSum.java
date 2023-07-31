package leetcode._15;

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        if(nums.length == 0){
            return new ArrayList<>(res);
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int lo = i+1;
            int hi = nums.length-1;
            while (lo < hi){
                int sum = nums[i]+nums[lo]+nums[hi];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
                } else if (sum > 0) {
                    hi-- ;
                }else {
                    lo++;
                }
            }
        }
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        var t = new ThreeSum();
        System.out.println(t.threeSum(new int[]{-1,0,1,2,-1,-4}));//Output: [[-1,-1,2],[-1,0,1]]
        System.out.println(t.threeSum(new int[]{0,1,1}));//Output: []
        System.out.println(t.threeSum(new int[]{0,0,0}));//Output: [[0,0,0]
    }
}
