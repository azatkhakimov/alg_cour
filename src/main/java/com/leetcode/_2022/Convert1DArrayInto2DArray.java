package main.java.com.leetcode._2022;

import java.util.Arrays;

public class Convert1DArrayInto2DArray {

    public int[][] construct2DArray(int[] original, int m, int n) {
        if(original.length != m*n){
            return new int[0][0];
        }

        int[][] result = new int[m][n];
        for (int i = 0; i < original.length; i++) {
            result[i/n][i%n] = original[i];
        }
        return result;
    }

    public static void main(String[] args) {
        var c = new Convert1DArrayInto2DArray();
        System.out.println(Arrays.deepToString(
                c.construct2DArray(new int[]{1,2,3,4}, 2, 2)));//Output: [[1,2],[3,4]]
        System.out.println(Arrays.deepToString(
                c.construct2DArray(new int[]{1,2,3}, 1, 3)));//Output: [[1,2,3]]
        System.out.println(Arrays.deepToString(
                c.construct2DArray(new int[]{1,2}, 1, 1)));//Output: []
    }
}
