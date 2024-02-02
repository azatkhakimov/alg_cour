package main.java.com.leetcode._2007;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class FindOriginalArrayFromDoubledArray {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        int i = 0;
        if (n % 2 == 1) {
            return new int[0];
        }
        int[] res = new int[n / 2];
        Map<Integer, Integer> count = new TreeMap<>();
        for (int a : changed) {
            count.put(a, count.getOrDefault(a, 0) + 1);
        }
        for (int x : count.keySet()) {
            if (count.get(x) > count.getOrDefault(x + x, 0)) {
                return new int[0];
            }
            for (int j = 0; j < count.get(x); j++) {
                res[i++] = x;
                count.put(x + x, count.get(x + x) - 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindOriginalArrayFromDoubledArray findOriginalArrayFromDoubledArray = new FindOriginalArrayFromDoubledArray();
        System.out.println(Arrays.toString(findOriginalArrayFromDoubledArray.findOriginalArray(new int[]{1, 3, 4, 2, 6, 8})));//Output: [1,3,4]
        System.out.println(Arrays.toString(findOriginalArrayFromDoubledArray.findOriginalArray(new int[]{6, 3, 0, 1})));//Output: []
        System.out.println(Arrays.toString(findOriginalArrayFromDoubledArray.findOriginalArray(new int[]{1})));//Output: []
    }
}
