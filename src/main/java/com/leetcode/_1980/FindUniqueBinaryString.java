package main.java.com.leetcode._1980;

public class FindUniqueBinaryString {

    public String findDifferentBinaryString(String[] nums) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            Character curr = nums[i].charAt(i);
            ans.append(curr == '0' ? '1' : '0');
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        var f = new FindUniqueBinaryString();
        System.out.println(f.findDifferentBinaryString(new String[]{"01","10"}));//Output: "11"
        System.out.println(f.findDifferentBinaryString(new String[]{"00","01"}));//Output: "11"
        System.out.println(f.findDifferentBinaryString(new String[]{"111","011","001"}));//Output: "101"
    }
}
