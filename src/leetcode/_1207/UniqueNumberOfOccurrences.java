package leetcode._1207;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        Set<Integer> occurrences = new HashSet<>(map.values());
        return occurrences.size() == map.size();
    }


    public static void main(String[] args) {
        UniqueNumberOfOccurrences occurrences = new UniqueNumberOfOccurrences();
        System.out.println(occurrences.uniqueOccurrences(new int[]{1,2,2,1,1,3}));//Output: true
        System.out.println(occurrences.uniqueOccurrences(new int[]{1,2}));//Output: false
        System.out.println(occurrences.uniqueOccurrences(new int[]{-3,0,1,-3,1,1,1,-3,10,0}));//Output: true
    }
}
