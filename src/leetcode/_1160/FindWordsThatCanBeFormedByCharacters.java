package leetcode._1160;

import java.util.HashMap;
import java.util.Map;

public class FindWordsThatCanBeFormedByCharacters {

    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : chars.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0)+1);
        }

        int ans = 0;
        for (String word : words) {
            Map<Character, Integer> wordCount = new HashMap<>();
            for (char c : word.toCharArray()) {
                wordCount.put(c, wordCount.getOrDefault(c, 0)+1);
            }
            boolean good = true;
            for (Character c : wordCount.keySet()) {
                if(counts.getOrDefault(c, 0) < wordCount.get(c)){
                    good = false;
                    break;
                }
            }
            if(good){
                ans += word.length();
            }
        }
        return  ans;
    }


    public static void main(String[] args) {
        var f = new FindWordsThatCanBeFormedByCharacters();
        System.out.println(f.countCharacters(new String[]{"cat","bt","hat","tree"}, "atach"));//Output: 6
        System.out.println(f.countCharacters(new String[]{"hello","world","leetcode"}, "welldonehoneyr"));//Output: 10
    }
}
