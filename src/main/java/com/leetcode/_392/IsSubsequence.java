package main.java.com.leetcode._392;

public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0){
            return true;
        }

        int indexS = 0;
        int indexT = 0;
        while (indexT < t.length()){
            if(t.charAt(indexT) == s.charAt(indexS)){
                indexS++;
                if(indexS == s.length()){
                    return true;
                }
            }
            indexT++;
        }
        return false;
    }

    public static void main(String[] args) {
        var i = new IsSubsequence();
        System.out.println(i.isSubsequence("abc", "ahbgdc"));//Output: true
        System.out.println(i.isSubsequence("axc", "ahbgdc"));//Output: false
    }
}
