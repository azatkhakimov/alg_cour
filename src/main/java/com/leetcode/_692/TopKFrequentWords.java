package main.java.com.leetcode._692;

import java.util.*;

//https://www.youtube.com/watch?v=cupg2TGIkyM
public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>((i1, i2) -> {
            if (i2.getValue() == i1.getValue()) {
                return i1.getKey().compareTo(i2.getKey());
            }
            return i2.getValue() - i1.getValue();
        });
        maxHeap.addAll(freq.entrySet());
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(maxHeap.poll().getKey());
        }
        return ans;
    }

    public static void main(String[] args) {
        TopKFrequentWords topKFrequentWords = new TopKFrequentWords();
        System.out.println(topKFrequentWords.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));//Output: ["i","love"]
        System.out.println(topKFrequentWords.topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"},
                4));//Output: ["the","is","sunny","day"]
    }
}
