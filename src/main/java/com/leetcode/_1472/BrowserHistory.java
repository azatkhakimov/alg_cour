package main.java.com.leetcode._1472;

import java.util.Stack;

class BrowserHistory {
    private Stack<String> history;
    private Stack<String> future;
    private String current;
    public BrowserHistory(String homepage) {
        history = new Stack<>();
        future = new Stack<>();
        current = homepage;
    }

    public void visit(String url) {
        history.push(url);
        current = url;
        future = new Stack<>();
    }

    public String back(int steps) {
        while (steps > 0 && !history.empty()){
            future.push(current);
            current = history.pop();
            steps--;
        }
        return current;
    }

    public String forward(int steps) {
        while (steps > 0 && !future.empty()){
            history.push(current);
            current = future.pop();
            steps--;
        }
        return current;
    }
}