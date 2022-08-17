package leetcode._387;

import java.util.HashMap;

public class FirstUniqueCharacterInaString {
    public int firstUniqChar(String s) {
        int n = s.length()-1;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            char cur = s.charAt(i);
            map.put(cur, map.getOrDefault(cur, 0)+1);
        }

        for (int i = 0; i <= n; i++) {
            if(map.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstUniqueCharacterInaString test = new FirstUniqueCharacterInaString();
        System.out.println(test.firstUniqChar("leetcode"));//Output: 0
        System.out.println(test.firstUniqChar("loveleetcode"));//Output: 2
        System.out.println(test.firstUniqChar("aabb"));//Output: -1
    }
}
