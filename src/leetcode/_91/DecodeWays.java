package leetcode._91;
//https://www.youtube.com/watch?v=cQX3yHS0cLo
public class DecodeWays {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() +1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i<=s.length(); i++){
            int oneDigit = Integer.parseInt(s.substring(i-1, i));
            int twoDigits = Integer.parseInt(s.substring(i-2, i));
            if(oneDigit >= 1){
                dp[i]+=dp[i-1];
            }
            if(twoDigits >= 10 && twoDigits <=26){
                dp[i]+=dp[i-2];
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        DecodeWays decodeWays = new DecodeWays();
        System.out.println(decodeWays.numDecodings("11"));
        System.out.println(decodeWays.numDecodings("12"));//Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
        System.out.println(decodeWays.numDecodings("226"));//Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
        System.out.println(decodeWays.numDecodings("06"));//Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").
    }
}
