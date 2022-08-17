package leetcode._804;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = new String[]{".-","-...","-.-.","-..",".","..-.","--.",
                "....","..",".---","-.-",".-..","--","-.",
                "---",".--.","--.-",".-.","...","-","..-",
                "...-",".--","-..-","-.--","--.."};

        Set<String> seen = new HashSet<>();
        for (String word : words) {
            StringBuilder code = new StringBuilder();
            for (char c : word.toCharArray()) {
                code.append(morse[c-'a']);
            }
            seen.add(code.toString());
        }
        return seen.size();
    }

    public static void main(String[] args) {
        UniqueMorseCodeWords uniqueMorseCodeWords = new UniqueMorseCodeWords();
        System.out.println(uniqueMorseCodeWords.uniqueMorseRepresentations(new String[]{"gin","zen","gig","msg"}));//Output: 2
        System.out.println(uniqueMorseCodeWords.uniqueMorseRepresentations(new String[]{"a"}));//Output: 1
    }
}
