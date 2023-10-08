package leetcode._316;

import java.util.Stack;

public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i)-'a'] = i;
        }

        boolean[] seen = new boolean[26];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            int curr = s.charAt(i)-'a';
            if(seen[curr]){
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > curr && i < lastIndex[stack.peek()]) {
                seen[stack.pop()] = false;
            }
            stack.push(curr);
            seen[curr] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append((char) (stack.pop()+'a'));
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        var r = new RemoveDuplicateLetters();
        System.out.println(r.removeDuplicateLetters("bcabc"));//Output: "abc"
        System.out.println(r.removeDuplicateLetters("cbacdcbc"));//Output: "acdb"
    }
}
