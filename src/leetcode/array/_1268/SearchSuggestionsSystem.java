package leetcode.array._1268;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionsSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        List<List<String>> result = new ArrayList<>();
        for (String product : products) {
            trie.insert(product);
        }
        String prefix = new String();
        for (char c : searchWord.toCharArray()) {
            prefix += c;
            result.add(trie.getWordStartingWith(prefix));
        }
        return result;
    }

    public static void main(String[] args) {
        SearchSuggestionsSystem searchSuggestionsSystem = new SearchSuggestionsSystem();
        System.out.println(searchSuggestionsSystem.suggestedProducts(new String[]{"mobile","mouse","moneypot","monitor","mousepad"},
                "mouse"));
    }

    class Trie{
        Trie(){
            root = new Node();
        }
        class Node{
            boolean isWord = false;
            List<Node> children = Arrays.asList(new Node[26]);
        }
        Node root;
        Node current;
        List<String> resultBuffer;

        void dfsWithPrefix(Node current, String word){
            if(resultBuffer.size() == 3){
                return;
            }
            if(current.isWord){
                resultBuffer.add(word);
            }
            for (char c = 'a'; c <= 'z'; c++){
                if(current.children.get(c-'a') != null){
                    dfsWithPrefix(current.children.get(c-'a'), word+c);
                }
            }
        }

        void insert(String s){
            current = root;
            for (char c : s.toCharArray()) {
                if(current.children.get(c-'a') == null){
                    current.children.set(c-'a', new Node());
                }
                current = current.children.get(c-'a');
            }
            current.isWord = true;
        }

        List<String> getWordStartingWith(String prefix){
            current = root;
            resultBuffer =  new ArrayList<>();
            for (char c : prefix.toCharArray()) {
                if(current.children.get(c-'a') == null){
                    return resultBuffer;
                }
                current = current.children.get(c-'a');
            }
            dfsWithPrefix(current, prefix);
            return resultBuffer;
        }
    }
}
