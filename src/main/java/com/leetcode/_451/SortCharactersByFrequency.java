package main.java.com.leetcode._451;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//https://www.youtube.com/watch?v=trFw8IDw2Vg
public class SortCharactersByFrequency {

    public String frequencySort(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0)+1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b)->freq.get(b)-freq.get(a));
        maxHeap.addAll(freq.keySet());
        StringBuilder stringBuilder = new StringBuilder();
        while (!maxHeap.isEmpty()){
            char curr = maxHeap.remove();
            for(int i = 0; i < freq.get(curr); i++){
                stringBuilder.append(curr);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        SortCharactersByFrequency frequency = new SortCharactersByFrequency();
        System.out.println(frequency.frequencySort("tree"));//Output: "eert"
        System.out.println(frequency.frequencySort("cccaaa"));//Output: "aaaccc"
        System.out.println(frequency.frequencySort("Aabb"));//Output: "bbAa"
    }
}
