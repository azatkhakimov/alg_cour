package leetcode._732;

import javax.imageio.ImageTranscoder;
import java.util.Map;
import java.util.TreeMap;

public class MyCalendarThree {
    Map<Integer, Integer> treeMap = null;

    public MyCalendarThree() {
        treeMap = new TreeMap<>();
    }

    public int book(int start, int end) {
        int sum = 0;
        int result = 0;
        treeMap.put(start, treeMap.getOrDefault(start, 0)+1);
        treeMap.put(end, treeMap.getOrDefault(end, 0)-1);
        for (Integer value : treeMap.values()) {
            sum += value;
            result = Math.max(result, sum);
        }
        return result;
    }
}
