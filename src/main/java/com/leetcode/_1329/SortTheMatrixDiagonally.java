package main.java.com.leetcode._1329;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortTheMatrixDiagonally {
    public int[][] diagonalSort(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        Map<Integer, PriorityQueue<Integer>> temp = new HashMap<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                temp.putIfAbsent(i-j, new PriorityQueue<>());
                temp.get(i-j).add(mat[i][j]);
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                mat[i][j] = temp.get(i-j).poll();
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        SortTheMatrixDiagonally sortTheMatrixDiagonally = new SortTheMatrixDiagonally();
        System.out.println(Arrays.deepToString(sortTheMatrixDiagonally.diagonalSort(new int[][]{
                {3, 3, 1, 1},
                {2, 2, 1, 2},
                {1, 1, 1, 2}})));//Output: [[1,1,1,1],[1,2,2,2],[1,2,3,3]]
        System.out.println(Arrays.deepToString(sortTheMatrixDiagonally.diagonalSort(new int[][]{
                {11, 25, 66, 1, 69, 7},
                {23, 55, 17, 45, 15, 52},
                {75, 31, 36, 44, 58, 8},
                {22, 27, 33, 25, 68, 4},
                {84, 28, 14, 11, 5, 50}})));//Output: [[5,17,4,1,52,7],[11,11,25,45,8,69],[14,23,25,44,58,15],[22,27,31,36,50,66],[84,28,75,33,55,68]]
    }
}
