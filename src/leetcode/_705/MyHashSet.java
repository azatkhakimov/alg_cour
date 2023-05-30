package leetcode._705;

public class MyHashSet {
    boolean[] ans;
    public MyHashSet() {
        ans = new boolean[1_000_001];
    }

    public void add(int key) {
        ans[key] = true;
    }

    public void remove(int key) {
        ans[key] = false;
    }

    public boolean contains(int key) {
        return ans[key];
    }
}
