package main.java.com.leetcode._1345;

import java.util.*;

public class JumpGameIV {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if(n <= 1){
            return 0;
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.computeIfAbsent(arr[i], v->new LinkedList<>()).add(i);
        }
        List<Integer> curs = new LinkedList<>();
        curs.add(0);
        Set<Integer> visited = new HashSet<>();
        int step = 0;
        while (!curs.isEmpty()){
            List<Integer> next = new LinkedList<>();
            for (Integer node : curs) {
                if(node == n - 1){
                    return step;
                }
                for (Integer child : graph.get(arr[node])) {
                    if(!visited.contains(child)){
                        visited.add(child);
                        next.add(child);
                    }
                }
                graph.get(arr[node]).clear();
                if(node+1 < n && !visited.contains(node+1)){
                    visited.add(node+1);
                    next.add(node+1);
                }
                if(node-1 >= 0 && !visited.contains(node-1)){
                    visited.add(node-1);
                    next.add(node-1);
                }
            }
            curs = next;
            step++;
        }
        return -1;
    }

    public static void main(String[] args) {
        JumpGameIV j = new JumpGameIV();
        System.out.println(j.minJumps(new int[]{100,-23,-23,404,100,23,23,23,3,404}));//Output: 3
        System.out.println(j.minJumps(new int[]{7,6,9,6,9,6,9,7}));//Output: 1
    }
}
