package leetcode.design._745_PrefixAndSuffixSearch;

public class WordFilter {
    TrieNode trieNode;

    public WordFilter(String[] words) {
        trieNode = new TrieNode();
        for (int weight = 0; weight < words.length; weight++) {
            String word = words[weight] + "{";
            for (int i = 0; i < word.length(); i++) {
                TrieNode current = trieNode;
                current.weight = weight;
                for(int j = i; j < 2*word.length()-1; j++){
                    int k = word.charAt(j % word.length()) - 'a';
                    if(current.children[k] == null){
                        current.children[k] = new TrieNode();
                    }
                    current = current.children[k];
                    current.weight = weight;
                }
            }
        }
    }
    public int f(String prefix, String suffix) {
        TrieNode current = trieNode;
        for(char letter : (suffix+ '{'+prefix).toCharArray()){
            if(current.children[letter-'a'] == null){
                return -1;
            }
            current = current.children[letter-'a'];
        }
        return current.weight;
    }

    public static void main(String[] args) {

    }

    private class TrieNode {
        TrieNode[] children;
        int weight;
        public TrieNode() {
            children = new TrieNode[27];
            weight = 0;
        }
    }
}
