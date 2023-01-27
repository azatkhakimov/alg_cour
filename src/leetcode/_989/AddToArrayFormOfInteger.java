package leetcode._989;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddToArrayFormOfInteger {
    public List<Integer> addToArrayForm(int[] num, int k) {
        int n = num.length;
        int cur = k;
        List<Integer> ans = new ArrayList<>();
        int i = n;
        while (--i >= 0 || cur > 0){
            if(i >=0 ){
                cur += num[i];
            }
            ans.add(cur % 10);
            cur /= 10;
        }
        Collections.reverse(ans);
        return ans;
    }
    public static void main(String[] args) {
        AddToArrayFormOfInteger i = new AddToArrayFormOfInteger();
        System.out.println(i.addToArrayForm(new int[]{1,2,0,0}, 34));//Output: [1,2,3,4]
        System.out.println(i.addToArrayForm(new int[]{2,7,4}, 181));//Output: [4,5,5]
        System.out.println(i.addToArrayForm(new int[]{2,1,5}, 806));//Output: [1,0,2,1]
    }
}
