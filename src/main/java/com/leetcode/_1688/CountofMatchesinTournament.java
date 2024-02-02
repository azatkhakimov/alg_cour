package main.java.com.leetcode._1688;

public class CountofMatchesinTournament {


    public int numberOfMatches(int n) {
        int ans = 0;
        while (n > 1) {
            if (n % 2 == 0) {
                ans += n / 2;
                n = n / 2;
            } else {
                ans += (n - 1) / 2;
                n = (n - 1) / 2 + 1;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        var c = new CountofMatchesinTournament();
        System.out.println(c.numberOfMatches(7));//Output: 6
        System.out.println(c.numberOfMatches(14));//Output: 13
    }
}
