package leetcode._446;

import java.util.HashMap;
import java.util.Map;

public class ArithmeticSlicesIISubsequence {
    public int numberOfArithmeticSlices(int[] nums) {
        int res = 0;
        Map<Integer, Integer>[] map = new Map[nums.length];
        for (int i = 0; i < nums.length; i++) {
            map[i] = new HashMap<>(i);

            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i]-nums[j];
                if(diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE){
                    continue;
                }
                int d = (int)diff;
                int c1 = map[i].getOrDefault(d, 0);
                int c2 = map[j].getOrDefault(d, 0);
                res += c2;
                map[i].put(d, c1+c2+1);
            }
        }
        return res;

     }

    public static void main(String[] args) {
        ArithmeticSlicesIISubsequence slices = new ArithmeticSlicesIISubsequence();
        System.out.println(slices.numberOfArithmeticSlices(new int[]{2,4,6,8,10}));//Output: 7
        System.out.println(slices.numberOfArithmeticSlices(new int[]{7,7,7,7,7}));//Output: 16
    }
}
