package main.java.com.leetcode._981;

import java.util.*;

public class TimeMap {
    Map<String, List<Data>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Data(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        return findClosest(map.get(key), timestamp);
    }

    private String findClosest(List<Data> data, int timestamp) {
        int left = 0;
        int right = data.size()-1;
        while (left < right){
            int mid = (left+right+1)/2;
            if(data.get(mid).timestamp <= timestamp){
                left = mid;
            }else {
                right = mid-1;
            }
        }
        Data closest = data.get(left);
        return closest.timestamp > timestamp ? "" : closest.value;
    }

    class Data{
        String value;
        int timestamp;
        public Data(String value, int timestamp){
            this.value = value;
            this.timestamp = timestamp;
        }
    }
}
