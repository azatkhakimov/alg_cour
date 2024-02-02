package main.java.com.leetcode._20;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0 || s.length() % 2 != 0){
            return false;
        }
        Stack<Character> operators = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char current = s.charAt(i);
            if('(' == current || '[' == current || '{' == current){
                operators.push(current);
            }else if(')' == current && !operators.isEmpty() && operators.peek() == '('){
                operators.pop();
            }else if(']' == current && !operators.isEmpty() && operators.peek() == '['){
                operators.pop();
            }else if('}' == current && !operators.isEmpty() && operators.peek() == '{'){
                operators.pop();
            } else {
                operators.push(current);
            }
        }
        return operators.isEmpty();
    }
    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        boolean result = validParentheses.isValid("([}}])");
        System.out.println(result);
    }
}
