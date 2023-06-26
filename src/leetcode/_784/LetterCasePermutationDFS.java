package leetcode._784;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LetterCasePermutationDFS {

    public List<String> letterCasePermutation(String s) {
        if(s == null){
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        dfs(s.toCharArray(), result, 0);
        return result;
    }

    private void dfs(char[] chars, List<String> result, int pos) {
        if(pos == chars.length){
            result.add(String.valueOf(chars));
            return;
        }

        if(chars[pos] >= '0' && chars[pos] <= '9'){
            dfs(chars, result, pos+1);
            return;
        }

        chars[pos] = Character.toLowerCase(chars[pos]);
        dfs(chars, result, pos+1);

        chars[pos] = Character.toUpperCase(chars[pos]);
        dfs(chars, result, pos+1);


    }
}
