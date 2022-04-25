package leetcode.string;

import edu.princeton.cs.algs4.In;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueCharacterString {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }

    ;

    public static void main(String[] args) {
        UniqueCharacterString uniqueCharacterString = new UniqueCharacterString();
        System.out.println(uniqueCharacterString.firstUniqChar("LOVELEETCODE"));
    }
}
