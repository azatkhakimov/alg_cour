package main.java.com.leetcode._981;
//https://www.youtube.com/watch?v=kZAZqn_J8Fo
public class TimeBasedKeyValueStore {
    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);// store the key "foo" and value "bar" along with timestamp = 1.
        System.out.println(timeMap.get("foo", 1));// return "bar"
        System.out.println(timeMap.get("foo", 3));//// return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
        timeMap.set("foo", "bar2", 4);//store the key "foo" and value "bar2" along with timestamp = 4.
        System.out.println(timeMap.get("foo", 4));//// return "bar2"
        System.out.println(timeMap.get("foo", 5));//// return "bar2"
    }

}
