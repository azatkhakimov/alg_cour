package main.java.com.leetcode._1496;

import java.util.*;

public class PathCrossing {

    public boolean isPathCrossing(String path) {
        Map<Character, List<Integer>> moves = new HashMap<>();
        moves.put('N', List.of(0, 1));
        moves.put('S', List.of(0, -1));
        moves.put('W', List.of(-1, 0));
        moves.put('E', List.of(1, 0));

        Set<List<Integer>> visited = new HashSet<>();
        visited.add(List.of(0, 0));
        int x = 0;
        int y = 0;
        for (char c : path.toCharArray()) {
            List<Integer> curr = moves.get(c);
            int dx = curr.get(0);
            int dy = curr.get(1);
            x += dx;
            y += dy;
            List<Integer> pair = List.of(x, y);
            if (visited.contains(pair)) {
                return true;
            }
            visited.add(pair);
        }
        return false;
    }


    public static void main(String[] args) {
        var p = new PathCrossing();
        System.out.println(p.isPathCrossing("NES"));//Output: false
        System.out.println(p.isPathCrossing("NESWW"));//Output: true
    }
}
