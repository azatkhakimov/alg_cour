package leetcode.backtracking._22;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> answers = new ArrayList<>();
        backtrack(answers, new StringBuilder(), 0, 0, n);
        return answers;
    }

    private void backtrack(List<String> answers, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max*2){
            answers.add(cur.toString());
            return;
        }
        if(open < max){
            cur.append("(");
            backtrack(answers, cur, open+1, close, max);
            cur.deleteCharAt(cur.length()-1);
        }
        if(close < open){
            cur.append(")");
            backtrack(answers, cur,open, close+1, max);
            cur.deleteCharAt(cur.length()-1);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        System.out.println(generateParentheses.generateParenthesis(3));
    }
}
