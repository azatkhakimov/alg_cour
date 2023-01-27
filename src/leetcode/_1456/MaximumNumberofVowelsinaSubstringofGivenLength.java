package leetcode._1456;

import java.util.HashSet;
import java.util.Set;

//*
// Algorithm
//
//    Build a hash set vowels that contains all 5 vowel letters, initialize answer as 0.
//
//    Record the number of vowel letters in the first k letters as count.
//
//    Now we move the "window" to the right, let i be the index of its right boundary:
//        If s[i] is in vowels, increment count by 1.
//        If s[i - k] is in vowels, reduce count by 1.
//        Update answer as the maximum count we have encountered.
//
//    Return answer after the iteration ends.
//    While moving the window, we keep track of the changes between adjacent windows and count the number of vowels count
//    in the current window as shown above, and update answer as the maximum count we have encountered.
//    *//
public class MaximumNumberofVowelsinaSubstringofGivenLength {
    public int maxVowels(String s, int k) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        int countVowels = 0;
        for(int i = 0; i < k; i++){
            countVowels += vowels.contains(s.charAt(i)) ? 1 : 0;
        }

        int answer = countVowels;
        for (int i = k; i < s.length(); i++) {
            countVowels += vowels.contains(s.charAt(i)) ? 1 : 0;
            countVowels -= vowels.contains(s.charAt(i-k)) ? 1 : 0;
            answer  = Math.max(answer, countVowels);
        }
        return answer;
    }

    public static void main(String[] args) {
        MaximumNumberofVowelsinaSubstringofGivenLength m = new MaximumNumberofVowelsinaSubstringofGivenLength();
        System.out.println(m.maxVowels( "abciiidef", 3));//", k = 3
        System.out.println(m.maxVowels("aeiou",  2));//Output: 2
        System.out.println(m.maxVowels("leetcode", 3));//Output: 2
    }
}
