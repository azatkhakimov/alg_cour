package leetcode.tree._208;

import java.util.Arrays;

public class TrieNode {
    private TrieNode[] links;

    private final int R = 26;

    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }

    @Override
    public String toString() {
        return "TrieNode{" +
                "links=" + Arrays.toString(links) +
                ", R=" + R +
                ", isEnd=" + isEnd +
                '}';
    }
}
