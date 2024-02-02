package leetcode._645;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int dup = -1;
        int missing = 1;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int i = 1; i < nums.length; i++) {
            if (map.containsKey(i)) {
                if (map.get(i) == 2) {
                    dup = i;
                }
            } else {
                missing = i;
            }
        }
        return new int[]{dup, missing};
    }

    public static void main(String[] args) {
        SetMismatch setMismatch = new SetMismatch();
        System.out.println(Arrays.toString(setMismatch.findErrorNums(new int[]{1, 2, 2, 4})));//Output: [2,3]
        System.out.println(Arrays.toString(setMismatch.findErrorNums(new int[]{1, 1})));//Output: [1,2]
    }
}
