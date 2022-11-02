package leetcode._692;

import java.util.*;
//https://www.youtube.com/watch?v=cupg2TGIkyM
public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0)+1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> {
            int freq1 = freqMap.get(o1);
            int freq2 = freqMap.get(o2);
            if(freq1 == freq2){
                return o2.compareTo(o1);
            }
            return freq1-freq2;
        });
        for (String s : freqMap.keySet()) {
            pq.add(s);
            if(pq.size() > k){
                pq.poll();
            }
        }
        List<String> res = new ArrayList<>();
        while (!pq.isEmpty()){
            res.add(pq.poll());
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        TopKFrequentWords topKFrequentWords = new TopKFrequentWords();
        System.out.println(topKFrequentWords.topKFrequent(new String[]{"i","love","leetcode","i","love","coding"},2));//Output: ["i","love"]
        System.out.println(topKFrequentWords.topKFrequent(new String[]{"the","day","is","sunny","the","the","the","sunny","is","is"},
                4));//Output: ["the","is","sunny","day"]
    }
}
