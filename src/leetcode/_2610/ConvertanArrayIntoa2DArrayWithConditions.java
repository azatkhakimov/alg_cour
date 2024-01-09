package leetcode._2610;

import java.util.ArrayList;
import java.util.List;

public class ConvertanArrayIntoa2DArrayWithConditions {

    public List<List<Integer>> findMatrix(int[] nums) {
        int[] freq = new int[nums.length+1];
        List<List<Integer>> ans = new ArrayList<>();
        for (int num : nums) {
            if(freq[num] >= ans.size()){
                ans.add(new ArrayList<>());
            }
            ans.get(freq[num]).add(num);
            freq[num]++;
        }
        return ans;

    }

    public static void main(String[] args) {
        var c = new ConvertanArrayIntoa2DArrayWithConditions();
        System.out.println(c.findMatrix(new int[]{1,3,4,1,2,3,1}));//Output: [[1,3,4,2],[1,3],[1]]
        System.out.println(c.findMatrix(new int[]{1,2,3,4}));//Output: [[4,3,2,1]]
    }
}
