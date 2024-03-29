package main.java.com.leetcode._232;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> pushStack;
    Stack<Integer> popStack;
    public MyQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    public void push(int x) {
        pushStack.push(x);
    }

    public int pop() {
        if(!popStack.isEmpty()){
            return popStack.pop();
        }
        while (!pushStack.isEmpty()){
            popStack.push(pushStack.pop());
        }
        return popStack.pop();
    }

    public int peek() {
        if(!popStack.isEmpty()){
            return popStack.peek();
        }
        while (!pushStack.isEmpty()){
            popStack.push(pushStack.pop());
        }
        return popStack.peek();
    }

    public boolean empty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }

}
