package leetcode._1470;

import java.util.Arrays;

public class ShuffleTheArray {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[n * 2];
        for (int i = 0; i < n; i++) {
            result[2 * i] = nums[i];
            result[2 * i + 1] = nums[n + i];
        }
        return result;
    }


    public static void main(String[] args) {
        ShuffleTheArray s = new ShuffleTheArray();
        System.out.println(Arrays.toString(s.shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3)));//Output: [2,3,5,4,1,7]
        System.out.println(Arrays.toString(s.shuffle(new int[]{1, 2, 3, 4, 4, 3, 2, 1}, 4)));//Output: [1,4,2,3,3,2,4,1]
        System.out.println(Arrays.toString(s.shuffle(new int[]{1, 1, 2, 2}, 2)));//Output: [1,2,1,2]
    }
}
