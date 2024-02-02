package main.java.com.leetcode._71;

import java.util.Stack;

public class SimplifyPath {

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] p = path.split("/");
        for (int i = 0; i < p.length; i++) {
            if(!stack.isEmpty() && "..".equals(p[i])){
                stack.pop();
            }else if (!p[i].equals("") && !p[i].equals(".") && !p[i].equals("..")){
                stack.push(p[i]);
            }

        }
        if(stack.isEmpty()){
            return "/";
        }
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()){
            ans.insert(0, stack.pop()).insert(0, "/");
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        SimplifyPath s = new SimplifyPath();
        System.out.println(s.simplifyPath("/home/"));//Output: "/home"
        System.out.println(s.simplifyPath("/../"));//Output: "/"
        System.out.println(s.simplifyPath("/home//foo/"));//Output: "/home/foo"
    }
}
