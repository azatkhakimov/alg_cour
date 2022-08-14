package leetcode._126;

import java.util.*;
//Кривое решение
public class WordLadderII {
    Set<String> set = new HashSet<>();
    String begin;
    String end;
    Map<String, Integer> dist = new HashMap<>();
    List<List<String>> res;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        begin = beginWord;
        end = endWord;
        res = new ArrayList<>();
        for (String s : wordList) {
            set.add(s);
        }
        shortPath();
        if(dist.get(endWord) == null){
            return res;
        }
        List<String> path = new ArrayList<>();
        path.add(endWord);
        dfs(endWord, path);
        return res;
    }

    private void dfs(String word, List<String> path) {
        if(word.equals(begin)){
            List<String> list = new ArrayList<>(path);
            Collections.reverse(list);
            res.add(list);
            return;
        }
        char[] charCur = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            char c = charCur[i];
            for(char j = 'a'; j<='z';j++){
                charCur[i] = j;
                String s = String.valueOf(charCur);
                if(dist.get(s) != null &&  dist.get(s)+1 == dist.get(word)){
                    path.add(s);
                    dfs(s, path);
                    path.remove(path.size()-1);
                }
            }
            charCur[i] = c;
        }
    }

    private void shortPath() {
        Queue<String> queue = new LinkedList<>();
        queue.offer(begin);
        dist.put(begin, 0);
        while (queue.size() > 0) {
            String cur = queue.poll();
            if(cur.equals(end)){
                break;
            }
            char[] charCurs = cur.toCharArray();
            for (int i = 0; i < cur.length(); i++) {
                char c = charCurs[i];
                for(char j = 'a'; j <='z'; j++){
                    charCurs[i] = j;
                    String s = String.valueOf(charCurs);
                    if(set.contains(s) && dist.get(s) == null){
                        dist.put(s, dist.get(cur)+1);
                        queue.offer(s);
                    }
                }
                charCurs[i] = c;
            }
        }
    }


    public static void main(String[] args) {
        WordLadderII wordLadderII = new WordLadderII();
        System.out.println(wordLadderII.findLadders("hit", "cog",
                Arrays.asList("hot","dot","dog","lot","log","cog")));//Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]));
        System.out.println(wordLadderII.findLadders( "hit", "cog",Arrays.asList("hot","dot","dog","lot","log")));//Output: []

    }
}
