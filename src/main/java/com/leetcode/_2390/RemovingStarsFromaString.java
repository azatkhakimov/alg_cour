package main.java.com.leetcode._2390;

public class RemovingStarsFromaString {

    public String removeStars(String s) {
        char[] c = new char[s.length()];
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if(cur == '*'){
                j--;
            }else {
                c[j++] = cur;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < j; i++) {
            stringBuilder.append(c[i]);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        RemovingStarsFromaString r = new RemovingStarsFromaString();
        System.out.println(r.removeStars("leet**cod*e"));//Output: "lecoe"
        System.out.println(r.removeStars("erase*****"));//Output: ""
    }
}
