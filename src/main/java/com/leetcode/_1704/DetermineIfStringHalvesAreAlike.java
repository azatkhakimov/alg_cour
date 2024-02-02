package main.java.com.leetcode._1704;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DetermineIfStringHalvesAreAlike {
    public boolean halvesAreAlike(String s) {
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u',
                'A', 'E', 'I', 'O', 'U'));

        int count = 0;
        int i = 0;
        int j = s.length()-1;
        while (i < j){
            if(set.contains(s.charAt(i++))){
                count++;
            }
            if(set.contains(s.charAt(j--))){
                count--;
            }
        }
        return count == 0;
    }

    public static void main(String[] args) {
        DetermineIfStringHalvesAreAlike alike = new DetermineIfStringHalvesAreAlike();
        System.out.println(alike.halvesAreAlike("book"));//Output: true
        System.out.println(alike.halvesAreAlike("textbook"));//Output: false
    }
}
