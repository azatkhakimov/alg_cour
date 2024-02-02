package main.java.com.leetcode._1759;

public class CountNumberOfHomogenousSubstrings {

    public int countHomogenous(String s) {
        int ans = 0;
        int currStreak = 0;
        int MOD = (int) 1e9 + 7;
        for (int i = 0; i < s.length(); i++) {
            if(i == 0 || s.charAt(i) == s.charAt(i-1)){
                currStreak++;
            }else {
                currStreak =  1;
            }
            ans = (ans + currStreak) % MOD;
        }
        return ans;
    }


    public static void main(String[] args) {
        var c = new CountNumberOfHomogenousSubstrings();
        System.out.println(c.countHomogenous("abbcccaa"));//Output: 13
        System.out.println(c.countHomogenous( "xy"));//Output: 2
        System.out.println(c.countHomogenous("zzzzz"));//Output: 15
    }
}
