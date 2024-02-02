package main.java.com.leetcode._1287;

import java.util.HashMap;
import java.util.Map;

public class ElementAppearingMoreThan25InSortedArray {


    public int findSpecialInteger(int[] arr) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : arr) {
            counts.put(num, counts.getOrDefault(num, 0)+1);
        }
        int target = arr.length / 4;
        for (Integer key : counts.keySet()) {
            if(counts.get(key) > target){
                return key;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        var e = new ElementAppearingMoreThan25InSortedArray();
        System.out.println(e.findSpecialInteger(new int[]{1,2,2,6,6,6,6,7,10}));//Output: 6
        System.out.println(e.findSpecialInteger(new int[]{1,1}));//Output: 1
    }
}
