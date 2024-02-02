package main.java.com.leetcode._767;

import java.util.*;

public class ReorganizeString {


    public String reorganizeString(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0)+1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((i1, i2)-> i2.getValue()-i1.getValue());
        maxHeap.addAll(freq.entrySet());

        Map.Entry<Character, Integer> prev = null;
        StringBuilder sb = new StringBuilder();

        while (!maxHeap.isEmpty() || prev != null) {
            if(prev != null && maxHeap.isEmpty()){
                return "";
            }
            Map.Entry<Character, Integer> currEntry = maxHeap.poll();
            int count = currEntry.getValue() - 1;
            sb.append(currEntry.getKey());
            if(prev != null){
                maxHeap.offer(prev);
                prev = null;
            }

            if(count != 0){
                prev = new AbstractMap.SimpleEntry<>(currEntry.getKey(), count);
            }


        }
        return sb.toString();
    }

    public static void main(String[] args) {
        var r = new ReorganizeString();
        System.out.println(r.reorganizeString("aab"));//Output: "aba"
        System.out.println(r.reorganizeString("aaab"));//Output: ""
    }
}
