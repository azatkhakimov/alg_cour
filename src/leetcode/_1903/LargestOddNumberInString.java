package leetcode._1903;

public class LargestOddNumberInString {

    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            if (Character.getNumericValue(num.charAt(i)) % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        var l = new LargestOddNumberInString();
        System.out.println(l.largestOddNumber("52"));//Output: "5"
        System.out.println(l.largestOddNumber("4206"));//Output: ""
        System.out.println(l.largestOddNumber("35427"));//Output: "35427"
    }
}
