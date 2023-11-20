package leetcode._2433;

import java.util.Arrays;

public class FindTheOriginalArrayOfPrefixXor {


    public int[] findArray(int[] pref) {
        int n = pref.length;

        int [] ans = new int[n];
        ans[0] = pref[0];
        for(int i = 1; i < n; i++){
            ans[i] = pref[i] ^ pref[i-1];
        }
        return ans;
    }

    public static void main(String[] args) {
        var f = new FindTheOriginalArrayOfPrefixXor();
        System.out.println(Arrays.toString(f.findArray(new int[]{5,2,0,3,1})));//Output: [5,7,2,3,2]
        System.out.println(Arrays.toString(f.findArray(new int[]{13})));//Output: [13]
    }
}
