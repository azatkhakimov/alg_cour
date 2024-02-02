package main.java.com.leetcode._168;

public class ExcelSheetColumnTitle {


    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            sb.append((char)((columnNumber) % 26 + 'A'));
            columnNumber = columnNumber / 26;

        }
        return sb.reverse().toString();
    }


    public static void main(String[] args) {
        var e = new ExcelSheetColumnTitle();
        System.out.println(e.convertToTitle(1));//Output: "A"
        System.out.println(e.convertToTitle(28));//Output: "AB"
        System.out.println(e.convertToTitle(701));//Output: "ZY"
    }
}
