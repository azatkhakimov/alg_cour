package main.java.com.leetcode._2391;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MinimumAmountOfTimeToCollectGarbage {


    public int garbageCollection(String[] garbage, int[] travel) {

        int[] prefixSum = new int[travel.length+1];
        prefixSum[1] = travel[0];
        for (int i = 1; i < travel.length; i++) {
            prefixSum[i+1] = prefixSum[i] + travel[i];
        }
        Map<Character, Integer> garbageLastPos = new HashMap<>();
        Map<Character, Integer> garbageCount = new HashMap<>();

        for (int i = 0; i < garbage.length; i++) {
            for (char c : garbage[i].toCharArray()) {
                garbageLastPos.put(c, i);
                garbageCount.put(c, garbageCount.getOrDefault(c, 0)+1);
            }
        }
        String garbageTypes = "MPG";
        int ans = 0;
        for (char c : garbageTypes.toCharArray()) {
            if(garbageCount.containsKey(c)){
                ans += prefixSum[garbageLastPos.get(c)] + garbageCount.get(c);
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        var m = new MinimumAmountOfTimeToCollectGarbage();
        System.out.println(m.garbageCollection(new String[]{"G","P","GP","GG"}, new int[]{2,4,3}));//Output: 21
        System.out.println(m.garbageCollection(new String[]{"MMM","PGM","GP"}, new int[]{3,10}));//Output: 37

        System.out.println(List.of("1", "1", "1", "2", "3").stream().filter(s -> !"1".equals(s) && !"2".equals(s)).collect(Collectors.toList()));
    }
}
