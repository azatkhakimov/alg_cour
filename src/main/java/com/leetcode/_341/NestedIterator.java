package main.java.com.leetcode._341;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

public class NestedIterator implements Iterator<Integer> {
    private Stack<ListIterator<NestedInteger>> lists;
    public NestedIterator(List<NestedInteger> nestedList) {
        lists = new Stack<>();
        lists.push(nestedList.listIterator());
    }

    @Override
    public boolean hasNext() {
        while (!lists.empty()) {
            if(!lists.peek().hasNext()){
                lists.pop();
            }else {
                NestedInteger x = lists.peek().next();
                if(x.isInteger()){
                    return lists.peek().previous() == x;
                }
                lists.push(x.getList().listIterator());
            }
        }
        return false;
    }

    @Override
    public Integer next() {
        hasNext();
        return lists.peek().next().getInteger();
    }

    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
}
