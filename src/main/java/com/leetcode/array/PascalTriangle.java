package main.java.com.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resultTri = new ArrayList<>();
        if (numRows == 0) {
            return resultTri;
        }
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        resultTri.add(firstRow);
        for (int i = 1; i < numRows; i++) {
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1);
            List<Integer> prevRow = resultTri.get(i - 1);
            for (int j = 1; j < i; j++) {
                currentRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            currentRow.add(1);
            resultTri.add(currentRow);
        }
        return resultTri;
    }

    public static void main(String[] args) {
        PascalTriangle pascalTriangle = new PascalTriangle();
        System.out.println(pascalTriangle.generate(5));
    }
}
