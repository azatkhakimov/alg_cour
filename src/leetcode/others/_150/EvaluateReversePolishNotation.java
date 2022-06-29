package leetcode.others._150;

import javax.naming.event.EventContext;
import java.text.NumberFormat;
import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0){
            return -1;
        }
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if ("+".equals(token)) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a + b);
            } else if ("-".equals(token)) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } else if ("*".equals(token)) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a * b);
            } else if ("/".equals(token)) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            }else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation test = new EvaluateReversePolishNotation();
        System.out.println(test.evalRPN(new String[]{"2", "1", "+", "3", "*"}));//9
        System.out.println(test.evalRPN(new String[]{"4", "13", "5", "/", "+"}));//6
        System.out.println(test.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}
