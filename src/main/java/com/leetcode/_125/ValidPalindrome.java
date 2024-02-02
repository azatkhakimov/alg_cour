package main.java.com.leetcode._125;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s.trim().length() == 1){
            return true;
        }
        s = s.replaceAll("[^A-Za-z0-9]", "");
        s = s.replaceAll("\\s+", "").toLowerCase();
        int end = s.length() - 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(validPalindrome.isPalindrome("race a car"));
    }
}
