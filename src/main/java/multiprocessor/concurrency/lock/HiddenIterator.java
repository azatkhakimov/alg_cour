package main.java.multiprocessor.concurrency.lock;

import java.util.HashSet;
import java.util.Set;

public class HiddenIterator {


    public static void main(String[] args) {
        final Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        System.out.println(set);
    }
}
