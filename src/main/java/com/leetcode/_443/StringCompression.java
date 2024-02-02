package main.java.com.leetcode._443;

public class StringCompression {
    public int compress(char[] chars) {
        int i = 0;
        int res = 0;
        while (i < chars.length){
            int groupLength = 1;
            while (i + groupLength < chars.length && chars[i+groupLength] == chars[i]){
                groupLength++;
            }
            chars[res++] = chars[i];
            if(groupLength > 1){
                for (char c : Integer.toString(groupLength).toCharArray()) {
                    chars[res++] = c;
                }
            }
            i += groupLength;
        }
        return res;
    }

    public static void main(String[] args) {
        StringCompression s = new StringCompression();
        System.out.println(s.compress(new char[]{'a','a','b','b','c','c','c'}));//Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
        System.out.println(s.compress(new char[]{'a'}));//Return 1, and the first character of the input array should be: ["a"]
        System.out.println(s.compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}));//Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].

    }
}
