package leetcode.string._1332;

public class RemovePalindromicSubsequences {
    public int removePalindromeSub(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int i = 0;
        int j = s.length()-1;
        while (i < j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else {
                return 2;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        RemovePalindromicSubsequences removePalindromicSubsequences = new RemovePalindromicSubsequences();
        System.out.println(removePalindromicSubsequences.removePalindromeSub("ababa"));
    }
}
