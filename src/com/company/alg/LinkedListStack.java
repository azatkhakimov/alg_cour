package com.company.alg;

public class LinkedListStack {
    private Node first;
    private class Node{
        String item;
        Node next;

        public Node(String item) {
            this.item = item;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "item='" + item + '\'' +
                    ", next=" + next +
                    '}';
        }
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void push(String item){
        Node oldFirst = first;
        first = new Node(item);
        first.next = oldFirst;
    }

    public String pop(){
        String value = first.item;
        first = first.next;
        return value;
    }

    public void print(){
        System.out.println(first);
    }

    public static void main(String[] args) {
        LinkedListStack linkedListStack = new LinkedListStack();
        linkedListStack.push("Hello");
        linkedListStack.push("Wordl");
        linkedListStack.print();
        linkedListStack.pop();
        linkedListStack.print();
        linkedListStack.pop();
        linkedListStack.print();

    }
}
