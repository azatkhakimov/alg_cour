package main.java.com.leetcode._2251;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NumberofFlowersinFullBloom {


    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        List<Integer> starts = new ArrayList<>();
        List<Integer> ends = new ArrayList<>();
        for (int[] flower : flowers) {
            starts.add(flower[0]);
            ends.add(flower[1]+1);
        }

        Collections.sort(starts);
        Collections.sort(ends);
        int[] ans = new int[people.length];
        for (int idx = 0; idx < people.length; idx++) {
            int person = people[idx];
            int i = binarySearch(starts, person);
            int j = binarySearch(ends, person);
            ans[idx] = i - j;
        }
        return ans;
    }

    private int binarySearch(List<Integer> arr, int target) {
        int left = 0;
        int right = arr.size();
        while (left < right){
            int mid = left + (right-left)/2;
            if(target < arr.get(mid)){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        var n = new NumberofFlowersinFullBloom();
        System.out.println(Arrays.toString(n.fullBloomFlowers(
                new int[][]{{1,6},{3,7},{9,12},{4,13}},
                new int[]{2,3,7,11}
        )));//Output: [1,2,2,2]
        System.out.println(Arrays.toString(n.fullBloomFlowers(
                new int[][]{{1,10},{3,3}},
                new int[]{3,3,2})));//Output: [2,2,1]
    }
}
