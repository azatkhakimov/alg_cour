package main.java.com.leetcode.string;

public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.isEmpty()) {
            return 0;
        }
        int m = haystack.length();
        int n = needle.length();
        if (m < n) {
            return -1;
        }
        for (int i = 0; i <= m - n; i++) {
            int j;
            for (j = 0; j < n; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == n) {
                return i;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        ImplementStrStr implementStrStr = new ImplementStrStr();
        System.out.println(implementStrStr.strStr("hello", "ll"));
        System.out.println(implementStrStr.strStr("aaaa", "bb"));
        System.out.println(implementStrStr.strStr("heoll", "ll"));
    }
}
