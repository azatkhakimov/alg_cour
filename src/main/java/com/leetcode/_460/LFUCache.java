package main.java.com.leetcode._460;

import java.util.*;

public class LFUCache {
    private Map<Integer, int[]> cache;
    private Map<Integer, LinkedHashSet<Integer>> frequencies;
    private int capacity;
    private int minf;

    public LFUCache(int capacity) {
        cache = new HashMap<>();
        frequencies = new HashMap<>();
        minf = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        int[] frequencyAndValue = cache.get(key);
        if (frequencyAndValue == null || frequencyAndValue.length == 0) {
            return -1;
        }
        int frequency = frequencyAndValue[0];
        Set<Integer> keys = frequencies.get(frequency);
        keys.remove(key);
        if (minf == frequency && keys.isEmpty()) {
            ++minf;
        }
        int value = frequencyAndValue[1];
        insert(key, frequency + 1, value);
        return value;
    }

    private void insert(int key, int frequency, int value) {
        cache.put(key, new int[]{frequency, value});
        frequencies.putIfAbsent(frequency, new LinkedHashSet<>());
        frequencies.get(frequency).add(key);
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }

        int[] frequencyAndValue = cache.get(key);
        if (frequencyAndValue != null && frequencyAndValue.length > 0) {
            cache.put(key, new int[]{frequencyAndValue[0], value});
            get(key);
            return;
        }

        if (capacity == cache.size()) {
            Set<Integer> keys = frequencies.get(minf);
            int keyToDelete = keys.iterator().next();
            cache.remove(keyToDelete);
            keys.remove(keyToDelete);
        }
        minf = 1;
        insert(key, 1, value);
    }

    public static void main(String[] args) {
        LFUCache lfu = new LFUCache(2);
        lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
        lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
        System.out.println(lfu.get(1));      // return 1
        // cache=[1,2], cnt(2)=1, cnt(1)=2
        lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
        // cache=[3,1], cnt(3)=1, cnt(1)=2
        System.out.println(lfu.get(2));      // return -1 (not found)
        System.out.println(lfu.get(3));      // return 3
        // cache=[3,1], cnt(3)=2, cnt(1)=2
        lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
        // cache=[4,3], cnt(4)=1, cnt(3)=2
        System.out.println(lfu.get(1));      // return -1 (not found)
        System.out.println(lfu.get(3));      // return 3
        // cache=[3,4], cnt(4)=1, cnt(3)=3
        System.out.println(lfu.get(4));      // return 4
        // cache=[4,3], cnt(4)=2, cnt(3)=3
    }
}
