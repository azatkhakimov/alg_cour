package leetcode.common.models.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Fibonachi {
    public int fibonacci(int n){
        int[] ans = new int[n+1];
        for (int i = 0; i <= n; i++) {
            ans[i] = -1;
        }
        return helper(n, ans);
    }

    private int helper(int n, int[] ans) {
        if(n <= 1){
            return n;
        }
        if(ans[n] != -1){
            return ans[n];
        }
        int x = helper(n-1, ans);
        int y = helper(n-2, ans);
        ans[n] = x+y;
        return ans[n];
    }

    public static void main(String[] args) {
        var f = new Fibonachi();
        System.out.println(f.fibonacci(6));
    }
}
