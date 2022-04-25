package com.company.alg;

import java.util.Iterator;

//FIFO
public class LinkedQueue<T> implements Iterable<T> {
    @Override
    public Iterator<T> iterator() {
        return new LinkedQueueIterator();
    }

    private class Node{
       private T item;
       private Node next;

        public Node(T item) {
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
    private Node first;
    private Node last;

    public boolean isEmpty(){
        return first == null;
    }

    public void enqueue(T item){
        Node oldLast = last;
        last = new Node(item);
        last.next = null;
        if(isEmpty()){
            first = last;
        }else {
            oldLast.next = last;
        }
    }

    public void print(){
        System.out.println("First: "+first +" last: "+last);
    }
    public T dequeue(){
        T item = first.item;
        first = first.next;
        if(isEmpty()){
            last = null;
        }
        return item;
    }

    public static void main(String[] args) {
        LinkedQueue<String> queue = new LinkedQueue<>();
        queue.enqueue("Hello");
        queue.enqueue("World");
        queue.enqueue("Boom");
//        queue.print();
        for (String s : queue) {
            System.out.println(s);
        }


    }

    private class LinkedQueueIterator implements Iterator<T> {
        private Node current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }
    }
}
