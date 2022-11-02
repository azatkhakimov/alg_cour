package leetcode._2136;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EarliestPossibleDayOfFullBloom {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = growTime.length;
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            indices.add(i);
        }

        Collections.sort(indices, Comparator.comparingInt(i -> -growTime[i]));
        int result = 0;
        for (int i = 0, curPlantTime = 0; i < n; i++) {
            int idx = indices.get(i);
            int time = curPlantTime + plantTime[idx] + growTime[idx];
            result = Math.max(result, time);
            curPlantTime += plantTime[idx];
        }
        return result;
    }


    public static void main(String[] args) {
        EarliestPossibleDayOfFullBloom epdfb = new EarliestPossibleDayOfFullBloom();
        System.out.println(epdfb.earliestFullBloom(new int[]{1,4,3}, new int[]{2,3,1}));//Output: 9
        System.out.println(epdfb.earliestFullBloom(new int[]{1,2,3,2}, new int[]{2,1,2,1}));//Output: 9
        System.out.println(epdfb.earliestFullBloom(new int[]{1}, new int[]{1}));//Output: 2
    }
}
