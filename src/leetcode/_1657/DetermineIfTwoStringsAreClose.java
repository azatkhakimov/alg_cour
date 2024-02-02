package leetcode._1657;

import java.util.*;

public class DetermineIfTwoStringsAreClose {

    public boolean closeStrings(String word1, String word2) {
        Map<Character, Integer> freqMapW1 = new HashMap();
        for (char c : word1.toCharArray()) {
            freqMapW1.put(c, freqMapW1.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> freqMapW2 = new HashMap<>();
        for (char c : word2.toCharArray()) {
            freqMapW2.put(c, freqMapW2.getOrDefault(c, 0) + 1);
        }

        if (!freqMapW1.keySet().equals(freqMapW2.keySet())) {
            return false;
        }

        List<Integer> freqW1 = new ArrayList<>(freqMapW1.values());
        List<Integer> freqW2 = new ArrayList<>(freqMapW2.values());
        Collections.sort(freqW1);
        Collections.sort(freqW2);
        return freqW1.equals(freqW2);
    }

    public static void main(String[] args) {
        DetermineIfTwoStringsAreClose close = new DetermineIfTwoStringsAreClose();
        System.out.println(close.closeStrings("abc", "bca"));//Output: true
        System.out.println(close.closeStrings("a", "aa"));//Output: false
        System.out.println(close.closeStrings("cabbba", "abbccc"));//Output: true
    }
}
