package main.java.com.leetcode._345;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('A');
        vowels.add('a');
        vowels.add('E');
        vowels.add('e');
        vowels.add('I');
        vowels.add('i');
        vowels.add('O');
        vowels.add('o');
        vowels.add('U');
        vowels.add('u');

        char[] chrs = s.toCharArray();
        int i = 0;
        int j = s.length()-1;
        while (i < j){
            while (i < j && !vowels.contains(chrs[i])){
                i++;
            }
            while (i < j && !vowels.contains(chrs[j])){
                j--;
            }
            char temp = chrs[i];
            chrs[i++] = chrs[j];
            chrs[j--] = temp;
        }
        return new String(chrs);
    }

    public static void main(String[] args) {
        ReverseVowelsOfAString reverseVowelsOfAString = new ReverseVowelsOfAString();
        System.out.println(reverseVowelsOfAString.reverseVowels("hello"));//Output: "holle"
        System.out.println(reverseVowelsOfAString.reverseVowels("leetcode"));//Output: "leotcede"
    }
}
