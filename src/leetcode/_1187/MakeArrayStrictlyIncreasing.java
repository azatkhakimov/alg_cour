package leetcode._1187;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MakeArrayStrictlyIncreasing {

    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Map<Integer, Integer> dp = new HashMap<>();
        Arrays.sort(arr2);
        int n = arr2.length;
        dp.put(-1, 0);

        for (int i = 0; i < arr1.length; i++) {
            Map<Integer, Integer> newDp = new HashMap<>();
            for (Integer prev : dp.keySet()) {
                if(arr1[i] > prev){
                    newDp.put(arr1[i], Math.min(newDp.getOrDefault(arr1[i], Integer.MAX_VALUE), dp.get(prev)));
                }
                int idx = bisectRight(arr2, prev);
                if(idx < n){
                    newDp.put(arr2[idx], Math.min(newDp.getOrDefault(arr2[idx], Integer.MAX_VALUE), 1+ dp.get(prev)));
                }
            }
            dp = newDp;
        }
        int answer = Integer.MAX_VALUE;
        for (Integer value : dp.values()) {
            answer = Math.min(answer, value);
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private int bisectRight(int[] arr, Integer value) {
        int left = 0;
        int right = arr.length;
        while (left < right){
            int mid = left+(right-left)/2;
            if (arr[mid] <= value){
                left = mid+1;
            }else {
                right = mid;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        var m = new MakeArrayStrictlyIncreasing();
        System.out.println(m.makeArrayIncreasing(new int[]{1,5,3,6,7}, new int[]{1,3,2,4}));//Output: 1
        System.out.println(m.makeArrayIncreasing(new int[]{1,5,3,6,7}, new int[]{4,3,1}));//Output: 2
        System.out.println(m.makeArrayIncreasing(new int[]{1,5,3,6,7}, new int[]{1,6,3,3}));//Output: -1

    }
}
