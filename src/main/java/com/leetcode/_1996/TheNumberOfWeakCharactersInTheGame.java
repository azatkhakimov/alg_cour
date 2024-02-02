package main.java.com.leetcode._1996;

import java.util.Arrays;

public class TheNumberOfWeakCharactersInTheGame {
    public int numberOfWeakCharacters(int[][] properties) {
        int n = properties.length;
        int count = 0;
        Arrays.sort(properties, (a, b) -> (b[0] == a[0]) ? (a[1] - b[1]) : b[0] - a[0]);
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (properties[i][1] < max) {
                count++;
            }
            max = Math.max(max, properties[i][1]);
        }
        return count;
    }

    public static void main(String[] args) {
        TheNumberOfWeakCharactersInTheGame test = new TheNumberOfWeakCharactersInTheGame();
        System.out.println(test.numberOfWeakCharacters(new int[][]{
                {5, 5},
                {6, 3},
                {3, 6}
        }));//Output: 0
        System.out.println(test.numberOfWeakCharacters(new int[][]{
                {2, 2},
                {3, 3}
        }));//Output: 1
    }
}
