package leetcode._383;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0)+1);
        }
        for (char c : ransomNote.toCharArray()) {
            if(!counts.containsKey(c) || counts.get(c) <= 0){
                return false;
            }
            counts.put(c, counts.get(c)-1);
        }
        return true;
    }

    public static void main(String[] args) {
        RansomNote ransomNote = new RansomNote();
        System.out.println(ransomNote.canConstruct("a", "b"));//Output: false
        System.out.println(ransomNote.canConstruct("aa", "ab"));//Output: false
        System.out.println(ransomNote.canConstruct("aa", "aab"));//Output: true
    }
}
