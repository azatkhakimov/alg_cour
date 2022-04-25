package com.company.alg;

import java.util.Arrays;

public class ArrayResizingQueue {
    String[] s;
    private int N = 0;
    private int head = 0;
    private int tail = 0;

    public ArrayResizingQueue() {
        this.s = new String[1];
    }

    private boolean isEmpty() {
        return N == 0;
    }

    private void enqueue(String item) {
        if (N == s.length) {
            resize(2 * s.length);
        }
        s[N++] = item;
        if (tail == s.length) {
            tail = 0;
        }
        tail++;
    }

    private String dequeue() {
        String item = s[head];
        s[head] = null;
        N--;
        head++;
        if (head == s.length) {
            head = 0;
        }
        if (N > 0 && N == s.length / 4) {
            resize(s.length / 2);
        }
        return item;
    }

    private void print() {
        System.out.println(Arrays.toString(s));
    }

    private void resize(int capacity) {
        String[] copy = new String[capacity];
        for (int i = 0; i < N; i++) {
            copy[i] = s[i + head];
        }
        s = copy;
        head = 0;
        tail = N;
    }

    public static void main(String[] args) {
        ArrayResizingQueue arrayResizingQueue = new ArrayResizingQueue();
        arrayResizingQueue.enqueue("Hello");
        arrayResizingQueue.enqueue("World");
        arrayResizingQueue.enqueue("Welcome");
        arrayResizingQueue.enqueue("To");
        arrayResizingQueue.enqueue("The");
        arrayResizingQueue.enqueue("party");
        arrayResizingQueue.print();
        arrayResizingQueue.dequeue();
        arrayResizingQueue.print();
        arrayResizingQueue.dequeue();
        arrayResizingQueue.print();
        arrayResizingQueue.dequeue();
        arrayResizingQueue.print();
        arrayResizingQueue.dequeue();
        arrayResizingQueue.print();
    }

}
