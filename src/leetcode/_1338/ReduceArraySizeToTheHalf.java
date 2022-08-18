package leetcode._1338;

import java.util.*;

public class ReduceArraySizeToTheHalf {
    public int minSetSize(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i,0)+1);
        }
        List<Integer> freqs = new ArrayList<>(map.values());
        Collections.sort(freqs, Collections.reverseOrder());
        int totalElems = n;
        int i = 0;
        while (totalElems > n/2){
            totalElems -= freqs.get(i);
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        ReduceArraySizeToTheHalf reduceArraySizeToTheHalf = new ReduceArraySizeToTheHalf();
        System.out.println(reduceArraySizeToTheHalf.minSetSize(new int[]{3,3,3,3,5,5,5,2,2,7}));//Output: 2
        System.out.println(reduceArraySizeToTheHalf.minSetSize(new int[]{7,7,7,7,7,7}));//Output: 1
    }
}
