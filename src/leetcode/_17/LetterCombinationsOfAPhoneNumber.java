package leetcode._17;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0){
            return result;
        }
        String[] mappingLetters = {
                "0",
                "1",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };
        combine(result, digits, "", 0, mappingLetters);
        return result;
    }

    private void combine(List<String> result, String digits, String current, int index, String[] mappingLetters) {
        if(index == digits.length()){
            result.add(current);
            return;
        }

        String letters = mappingLetters[digits.charAt(index)-'0'];
        for (char letter : letters.toCharArray()) {
            combine(result, digits, current+letter, index+1, mappingLetters);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber letterCombinationsOfAPhoneNumber = new LetterCombinationsOfAPhoneNumber();
        System.out.println(letterCombinationsOfAPhoneNumber.letterCombinations("23"));//Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
        System.out.println(letterCombinationsOfAPhoneNumber.letterCombinations(""));//Output: []
        System.out.println(letterCombinationsOfAPhoneNumber.letterCombinations("2"));//Output: ["a","b","c"]
    }
}
