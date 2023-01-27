package leetcode._680;

public class ValidPalindromeII {


    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        while (left <= right){
            if(s.charAt(left) != s.charAt(right)){
                return palindrome(s, left+1, right) || palindrome(s, left, right-1);
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean palindrome(String s, int left, int right) {
        while (left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindromeII v = new ValidPalindromeII();
        System.out.println(v.validPalindrome("aba"));//Output: true
        System.out.println(v.validPalindrome("abca"));//Output: true
        System.out.println(v.validPalindrome("abc"));//Output: false
    }
}
