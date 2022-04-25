package com.company.alg;

import edu.princeton.cs.algs4.Stack;

import java.util.stream.Stream;

public class DiikstraTwoStack {
    Stack<Integer> operand = new Stack<>();
    Stack<Character> operator = new Stack<>();

    public int calculate(String math) {
        for (int i = 0; i< math.length(); i++) {
            char c = math.charAt(i);
            if('(' == c){

            }
            if ('*' == c || '+' == c) {
                operator.push(c);
            } else if (')' == c) {
                Character operator = this.operator.pop();
                if ('*' == operator) {
                    operand.push(operand.pop().intValue() * operand.pop().intValue());
                } else if ('+' == operator) {
                    operand.push(operand.pop().intValue() + operand.pop().intValue());
                }
            } else {
                operand.push((int) c);
            }
        }
        return operand.pop();
    }

    public static void main(String[] args) {
        DiikstraTwoStack diikstraTwoStack = new DiikstraTwoStack();
        System.out.println(diikstraTwoStack.calculate("(1+((2+3)*(4+5)))"));
    }
}
