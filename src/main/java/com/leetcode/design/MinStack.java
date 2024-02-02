package main.java.com.leetcode.design;

public class MinStack {
    public LinkList first;

    class LinkList {
        private int val;
        private LinkList next;

        public LinkList(int val) {
            this.val = val;
        }

        public LinkList(int val, LinkList next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "LinkList{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public MinStack() {

    }

    public void push(int val) {
        if (first == null) {
            first = new LinkList(val);
        } else {
            LinkList temp = first;
            first = new LinkList(val);
            first.next = temp;
        }
    }

    public void pop() {
        if (first == null) {
            return;
        }
        first = first.next;
    }

    public int top() {
        if (first == null) {
            return -1;
        }
        return first.val;
    }

    public int getMin() {
        int result = Integer.MAX_VALUE;
        LinkList head = first;
        while (head != null) {
            result = Math.min(result, head.val);
            head = head.next;
        }
        return result;
    }

    public void print() {
        System.out.println(first);
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.print();
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.print();
            System.out.println(minStack.top());
            System.out.println(minStack.getMin());
    }
}
