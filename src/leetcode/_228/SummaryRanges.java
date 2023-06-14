package leetcode._228;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];

            while (i + 1 < nums.length && nums[i]+1 == nums[i+1]){
                i++;
            }

            if(start != nums[i]){
                ranges.add(start + "->"+nums[i]);
            }else {
                ranges.add(String.valueOf(nums[i]));
            }
        }
        return ranges;
    }

    public static void main(String[] args) {
        var s = new SummaryRanges();
        System.out.println(s.summaryRanges(new int[]{0,1,2,4,5,7}));//Output: ["0->2","4->5","7"]
        System.out.println(s.summaryRanges(new int[]{0,2,3,4,6,8,9}));//Output: ["0","2->4","6","8->9"]
    }
}
