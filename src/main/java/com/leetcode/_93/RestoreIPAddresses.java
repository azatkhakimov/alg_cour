package main.java.com.leetcode._93;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class RestoreIPAddresses {
    private int n;
    private String str;
    private ArrayList<String> result;
    private LinkedList<String> segments;

    public List<String> restoreIpAddresses(String s) {
        n = s.length();
        str = s;
        result = new ArrayList<>();
        segments = new LinkedList<>();
        backtrack(-1, 3);
        return result;
    }

    private void backtrack(int prevDot, int dots) {
        int maxPos = Math.min(n - 1, prevDot + 4);
        for (int currDot = prevDot + 1; currDot < maxPos; currDot++) {
            String segment = str.substring(prevDot + 1, currDot + 1);
            if (valid(segment)) {
                segments.add(segment);
                if (dots - 1 == 0) {
                    updateSegments(currDot);
                } else {
                    backtrack(currDot, dots - 1);
                }
                segments.removeLast();
            }
        }
    }

    private void updateSegments(int currDot) {
        String segment = str.substring(currDot+1, n);
        if(valid(segment)){
            segments.add(segment);

            String ip = String.join(".",segments);
            result.add(ip);
            segments.removeLast();
        }
    }

    private boolean valid(String segment) {
        int m = segment.length();
        if (m > 3) {
            return false;
        }
        return (segment.charAt(0) != '0') ? (Integer.valueOf(segment) <= 255) : (m == 1);
    }


    public static void main(String[] args) {
        RestoreIPAddresses ipAddresses = new RestoreIPAddresses();
        System.out.println(ipAddresses.restoreIpAddresses("25525511135"));//Output: ["255.255.11.135","255.255.111.35"]
        System.out.println(ipAddresses.restoreIpAddresses("0000"));//Output: ["0.0.0.0"]
        System.out.println(ipAddresses.restoreIpAddresses("101023"));//Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
    }
}
