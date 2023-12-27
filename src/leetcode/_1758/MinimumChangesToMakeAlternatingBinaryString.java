package leetcode._1758;

public class MinimumChangesToMakeAlternatingBinaryString {


    public int minOperations(String s) {
        int start0 = 0;
        int start1 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                if (s.charAt(i) == '0') {
                    start1++;
                } else {
                    start0++;
                }
            } else {
                if (s.charAt(i) == '1') {
                    start1++;
                } else {
                    start0++;
                }
            }
        }
        return Math.min(start0, start1);
    }

    public static void main(String[] args) {
        var m = new MinimumChangesToMakeAlternatingBinaryString();
        System.out.println(m.minOperations("0100"));//Output: 1
        System.out.println(m.minOperations("10"));//Output: 0
        System.out.println(m.minOperations("1111"));//Output: 2
    }
}
