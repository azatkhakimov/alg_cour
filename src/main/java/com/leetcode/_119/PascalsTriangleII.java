package main.java.com.leetcode._119;

import java.util.Arrays;
import java.util.List;

public class PascalsTriangleII {


    public List<Integer> getRow(int rowIndex) {
        Integer[] ans = new Integer[rowIndex+1];
        Arrays.fill(ans, 0);
        ans[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i; j > 0; j--) {
                ans[j] = ans[j] + ans[j-1];
            }
        }
        return Arrays.asList(ans);
    }

    public static void main(String[] args) {
        PascalsTriangleII p = new PascalsTriangleII();
        System.out.println(p.getRow(3));//Output: [1,3,3,1]
        System.out.println(p.getRow(0));//Output: [1]
        System.out.println(p.getRow(1));//Output: [1,1]

    }
}
