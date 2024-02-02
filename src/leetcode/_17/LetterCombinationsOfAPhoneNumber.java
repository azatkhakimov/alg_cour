package leetcode._17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    List<String> ans;
    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        if(digits == null || digits.isEmpty()){
            return ans;
        }

        Map<Character, String[]> dict = new HashMap<>();
        dict.put('1', new String[]{""});
        dict.put('2', new String[]{"a", "b", "c"});
        dict.put('3', new String[]{"d", "e", "f"});
        dict.put('4', new String[]{"g", "h", "i"});
        dict.put('5', new String[]{"j", "k", "l"});
        dict.put('6', new String[]{"m", "n", "o"});
        dict.put('7', new String[]{"p", "q", "r", "s"});
        dict.put('8', new String[]{"t", "u", "v"});
        dict.put('9', new String[]{"w", "x", "y", "z"});
        backtrack(0, new StringBuilder(), digits, dict);
        return ans;
    }

    private void backtrack(int index, StringBuilder path, String digits, Map<Character, String[]> dict) {
        if(path.length() == digits.length()){
            ans.add(path.toString());
            return;
        }

        char digit = digits.charAt(index);
        String[] possibleLetters = dict.get(digit);
        for (String possibleLetter : possibleLetters) {
            path.append(possibleLetter);
            backtrack(index+1, path, digits, dict);
            path.deleteCharAt(path.length()-1);
        }
    }


    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber letterCombinationsOfAPhoneNumber = new LetterCombinationsOfAPhoneNumber();
        System.out.println(letterCombinationsOfAPhoneNumber.letterCombinations("23"));//Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
        System.out.println(letterCombinationsOfAPhoneNumber.letterCombinations(""));//Output: []
        System.out.println(letterCombinationsOfAPhoneNumber.letterCombinations("2"));//Output: ["a","b","c"]
    }
}
