package main.java.com.leetcode._1630;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArithmeticSubarrays {

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            int[] arr = new int[r[i]-l[i]+1];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = nums[l[i]+j];
            }
            ans.add(check(arr));
        }
        return ans;
    }

    private Boolean check(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1]-arr[0];
        for (int i = 2; i < arr.length; i++) {
            if(arr[i] - arr[i-1] != diff){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        var a = new ArithmeticSubarrays();
        System.out.println(a.checkArithmeticSubarrays(new int[]{4, 6, 5, 9, 3, 7}, new int[]{0, 0, 2}, new int[]{2, 3, 5}));//Output: [true,false,true]
        System.out.println(a.checkArithmeticSubarrays(new int[]{-12, -9, -3, -12, -6, 15, 20, -25, -20, -15, -10},
                new int[]{0, 1, 6, 4, 8, 7}, new int[]{4, 4, 9, 7, 9, 10}));//Output: [false,true,false,false,true,true]
    }
}
