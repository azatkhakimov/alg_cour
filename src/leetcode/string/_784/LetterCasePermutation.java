package leetcode.string._784;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LetterCasePermutation {
    public List<String> letterCasePermutation(String s) {
        if (s == null){
            return new LinkedList<>();
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);

        for (int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i))){
                continue;
            }
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String cur = queue.poll();
                char[] chars = cur.toCharArray();

                chars[i] = Character.toUpperCase(chars[i]);
                queue.offer(String.valueOf(chars));

                chars[i] = Character.toLowerCase(chars[i]);
                queue.offer(String.valueOf(chars));
            }
        }
        return new LinkedList<>(queue);
    }

    public static void main(String[] args) {
        LetterCasePermutation letterCasePermutation = new LetterCasePermutation();
        System.out.println(letterCasePermutation.letterCasePermutation( "a1b2"));//["a1b2","a1B2","A1b2","A1B2"]
        System.out.println(letterCasePermutation.letterCasePermutation("3z4"));//Output: ["3z4","3Z4"]
    }
}
