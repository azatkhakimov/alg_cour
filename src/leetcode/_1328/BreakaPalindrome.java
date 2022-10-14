package leetcode._1328;

public class BreakaPalindrome {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length() == 1){
            return "";
        }
        char[] palChars = palindrome.toCharArray();
        for(int i = 0; i < palindrome.length()/2; i++){
            if(palChars[i] != 'a'){
                palChars[i] = 'a';
                return String.valueOf(palChars);
            }
        }
        if(palChars[palChars.length-1] != 'b'){
            palChars[palChars.length-1]  = 'b';
        }
        return String.valueOf(palChars);
    }


    public static void main(String[] args) {
        BreakaPalindrome breakaPalindrome = new BreakaPalindrome();
        System.out.println(breakaPalindrome.breakPalindrome("abccba"));//"aaccba"
        System.out.println(breakaPalindrome.breakPalindrome("a"));//Output: ""
    }
}
