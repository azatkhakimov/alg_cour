package main.java.com.leetcode._59;

import java.util.Arrays;

public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        int top = 0;
        int left = 0;
        int right = n - 1;
        int bottom = n - 1;
        int num = 1;
        int[][] answer = new int[n][n];
        while (left <= right && top <= bottom){
            for(int i = left; i <= right; i++){
                answer[top][i] = num++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                answer[i][right] = num++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                answer[bottom][i] = num++;
            }
            bottom--;

            for (int i = bottom; i >= top; i--) {
                answer[i][left] = num++;
            }
            left++;

        }
        return answer;
    }


    public static void main(String[] args) {
        var s = new SpiralMatrixII();
        System.out.println(Arrays.deepToString(s.generateMatrix(3)));//Output: [[1,2,3],[8,9,4],[7,6,5]]
        System.out.println(Arrays.deepToString(s.generateMatrix(1)));//Output: [[1]]
        System.out.println(Arrays.deepToString(s.generateMatrix(4)));//Output: [[1,2,3,4],[12,13,14,5],[11,16,15,6],[10,9,8,7]]

    }
}
