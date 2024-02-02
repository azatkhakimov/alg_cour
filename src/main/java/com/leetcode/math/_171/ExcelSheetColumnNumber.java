package main.java.com.leetcode.math._171;

public class ExcelSheetColumnNumber {
    public int titleToNumber(String columnTitle) {
        if(columnTitle == null){
            return -1;
        }
        int sum = 0;
        for (char c : columnTitle.toCharArray()) {
            sum *= 26;
            sum += c - 'A' +1;
        }
        return sum;
    }

    public static void main(String[] args) {
        ExcelSheetColumnNumber excelSheetColumnNumber = new ExcelSheetColumnNumber();
        System.out.println(excelSheetColumnNumber.titleToNumber("ZY"));
    }

}
