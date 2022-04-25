package com.company.alg;

import java.util.Arrays;

public class ArrayStack {
    private String[] s;
    private int N;
    public ArrayStack(int capacity) {
        s = new String[capacity];
    }
    public boolean isEmpty(){
        return N == 0;
    }

    public void push(String item){
        s[N++] = item;
    }
    public String pop(){
        String item = this.s[--N];
        this.s[N] = null;
        return item;
    }
    public void print(){
        System.out.println(Arrays.toString(s));
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(10);
        System.out.println(arrayStack.isEmpty());
        arrayStack.push("Hello");
        arrayStack.print();
        System.out.println(arrayStack.isEmpty());
        arrayStack.push("World");
        arrayStack.print();
        arrayStack.push("By");
        arrayStack.print();
        arrayStack.pop();
        arrayStack.print();
        arrayStack.pop();
        arrayStack.print();
        arrayStack.pop();
        arrayStack.print();
        System.out.println(arrayStack.isEmpty());

    }
}
