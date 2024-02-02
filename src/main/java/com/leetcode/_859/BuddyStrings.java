package main.java.com.leetcode._859;

public class BuddyStrings {


    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }
        if(s.equals(goal)){
            char[] frequency = new char[26];
            for (char c : s.toCharArray()) {
                frequency[c-'a'] +=1;
                if(frequency[c-'a'] == 2){
                    return true;
                }
            }
            return false;
        }

        int firstIdx = -1;
        int secondIdx = -1;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != goal.charAt(i)){
               if(firstIdx == -1){
                   firstIdx = i;
               } else if (secondIdx == -1) {
                   secondIdx = i;
               }else {
                   return false;
               }
            }
        }
        if(secondIdx == -1){
            return false;
        }
        return s.charAt(firstIdx) == goal.charAt(secondIdx) && s.charAt(secondIdx) == goal.charAt(firstIdx);
    }

    public static void main(String[] args) {
        var b = new BuddyStrings();
        System.out.println(b.buddyStrings("ab", "ba"));//Output: true
        System.out.println(b.buddyStrings("ab", "ab"));//Output: false
        System.out.println(b.buddyStrings("aa",  "aa"));//Output: true
    }
}
