package leetcode._1814;

import java.util.HashMap;
import java.util.Map;

public class CountNicePairsInanArray {


    public int countNicePairs(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i] - rev(nums[i]);
        }

        Map<Integer, Integer> dic = new HashMap<>();
        int ans = 0;
        int MOD = (int) 1e9+7;
        for (int num : arr) {
            ans = (ans+dic.getOrDefault(num, 0)) % MOD;
            dic.put(num, dic.getOrDefault(num, 0) +1);
        }
        return ans;
    }

    public int rev(int num){
        int result = 0;
        while (num != 0){
            result = result * 10 + num % 10;
            num /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        var c = new CountNicePairsInanArray();
        System.out.println(c.countNicePairs(new int[]{42,11,1,97}));//Output: 2
        System.out.println(c.countNicePairs(new int[]{13,10,35,24,76}));//Output: 4
    }
}
