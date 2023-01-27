package leetcode._6;

import java.util.Arrays;

public class ZigzagConversion {
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }

        int n = s.length();
        int sections = (int)Math.ceil(n/(2*numRows-2.0));
        int numCols = sections * (numRows-1);

        char[][] matrix = new char[numRows][numCols];
        for (char[] row : matrix) {
            Arrays.fill(row, ' ');
        }

        int curRow = 0;
        int curCol = 0;
        int curStringIndex = 0;

        while (curStringIndex < n){
            while (curRow < numRows && curStringIndex < n){
                matrix[curRow][curCol] = s.charAt(curStringIndex);
                curRow++;
                curStringIndex++;
            }
            curRow -= 2;
            curCol++;

            while (curRow > 0 && curCol < numCols && curStringIndex < n){
                matrix[curRow][curCol] = s.charAt(curStringIndex);
                curRow--;
                curCol++;
                curStringIndex++;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char[] row : matrix) {
            for (char c : row) {
                if(c != ' '){
                    stringBuilder.append(c);
                }
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        ZigzagConversion zigzagConversion = new ZigzagConversion();
        System.out.println(zigzagConversion.convert("PAYPALISHIRING", 3));//Output: "PAHNAPLSIIGYIR"
        System.out.println(zigzagConversion.convert("PAYPALISHIRING", 4));//Output: "PINALSIGYAHRPI"
    }
}
