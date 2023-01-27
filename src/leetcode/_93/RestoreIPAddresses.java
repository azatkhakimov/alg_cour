package leetcode._93;

import java.util.ArrayList;
import java.util.List;



public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        helper(s, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void helper(String s, int startIndex, List<Integer> dots, List<String> ans) {
        int remainingLength = s.length()-startIndex;
        int remainingNumberOfInts = 4 - dots.size();
        if(remainingLength > remainingNumberOfInts * 3 ||
        remainingLength < remainingNumberOfInts){
            return;
        }

        if(dots.size() == 3){
            if(valid(s, startIndex, remainingLength)){
                StringBuilder stringBuilder = new StringBuilder();
                int last = 0;
                for (Integer dot : dots) {
                    stringBuilder.append(s.substring(last, last+dot));
                    last += dot;
                    stringBuilder.append(".");
                }
                stringBuilder.append(s.substring(startIndex));
                ans.add(stringBuilder.toString());
            }
            return;
        }
        for (int curPos = 1; curPos <= 3 && curPos <= remainingLength; curPos++){
            dots.add(curPos);
            if(valid(s, startIndex, curPos)){
                helper(s, startIndex+curPos, dots, ans);
            }
            dots.remove(dots.size()-1);
        }
    }

    private boolean valid(String s, int startIndex, int length) {
        return length == 1 || (s.charAt(startIndex) != '0' && (length < 3
        || s.substring(startIndex, startIndex+length).compareTo("255")<= 0));
    }

    public static void main(String[] args) {
        RestoreIPAddresses ipAddresses = new RestoreIPAddresses();
        System.out.println(ipAddresses.restoreIpAddresses("25525511135"));//Output: ["255.255.11.135","255.255.111.35"]
        System.out.println(ipAddresses.restoreIpAddresses("0000"));//Output: ["0.0.0.0"]
        System.out.println(ipAddresses.restoreIpAddresses("101023"));//Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
    }
}
