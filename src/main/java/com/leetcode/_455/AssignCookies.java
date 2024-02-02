package main.java.com.leetcode._455;

import java.util.Arrays;

public class AssignCookies {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int contentChildren = 0;
        int cookieIndex = 0;
        while (cookieIndex < s.length && contentChildren < g.length) {
            if(s[cookieIndex] >= g[contentChildren]){
                contentChildren++;
            }
            cookieIndex++;
        }
        return contentChildren;
    }
    public static void main(String[] args) {
        var a = new AssignCookies();
        System.out.println(a.findContentChildren(new int[]{1,2,3}, new int[]{1,1}));//Output: 1
        System.out.println(a.findContentChildren(new int[]{1,2}, new int[]{1,2,3}));//Output: 2
    }
}
