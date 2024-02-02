package main.java.com.leetcode.design;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedIterator implements Iterator<Integer> {

    private Stack<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList){
        stack = new Stack<>();
        flattenList(nestedList);
    }

    private void flattenList(List<NestedInteger> nestedList) {
        for(int i = nestedList.size() - 1; i >= 0; i--){
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty()){
            if(stack.peek().isInteger()){
                return true;
            }
            flattenList(stack.pop().getList());
        }
        return false;
    }

    private List<NestedIterator> getList() {
        //main.java.com.leetcode impl
        throw new UnsupportedOperationException();
    }

    private boolean isInteger() {
        //main.java.com.leetcode impl
        throw new UnsupportedOperationException();
    }



    @Override
    public Integer next() {
        return hasNext() ? stack.pop().getInteger() : null;
    }

    private Integer getInteger() {
        //main.java.com.leetcode impl
        throw new UnsupportedOperationException();
    }

    private class NestedInteger {
        Integer getInteger(){
            throw new UnsupportedOperationException();
        }

        public boolean isInteger() {
            throw new UnsupportedOperationException();
        }

        public List<NestedInteger> getList() {
            throw new UnsupportedOperationException();
        }
    }
}
