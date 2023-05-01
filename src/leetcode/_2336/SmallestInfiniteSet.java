package leetcode._2336;

import java.util.HashSet;
import java.util.PriorityQueue;

public class SmallestInfiniteSet {
    private HashSet<Integer> present;
    private PriorityQueue<Integer> added;
    private int currentInteger;
    public SmallestInfiniteSet() {
        present =new HashSet<>();
        added = new PriorityQueue<>();
        currentInteger = 1;
    }

    public int popSmallest() {
        int answer;
        if(!added.isEmpty()){
            answer = added.poll();
            present.remove(answer);
        }else {
            answer = currentInteger;
            currentInteger += 1;
        }
        return answer;
    }

    public void addBack(int num) {
        if(currentInteger <= num || present.contains(num)){
            return;
        }
        present.add(num);
        added.add(num);
    }

}
