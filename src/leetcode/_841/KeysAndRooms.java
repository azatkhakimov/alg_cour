package leetcode._841;

import java.util.*;

//https://www.youtube.com/watch?v=oYeGiShGn2k
public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        visited.add(0);

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        while (!stack.isEmpty()){
            List<Integer> keys = rooms.get(stack.pop());
            for (Integer key : keys) {
                if(!visited.contains(key)){
                    visited.add(key);
                    stack.add(key);
                }
            }
        }
        return rooms.size() == visited.size();
    }


    public static void main(String[] args) {
        KeysAndRooms keysAndRooms = new KeysAndRooms();
        System.out.println(keysAndRooms.canVisitAllRooms(List.of(
                List.of(1),
                List.of(2),
                List.of(3),
                List.of())));//Output: true
        System.out.println(keysAndRooms.canVisitAllRooms(List.of(
                List.of(1, 3),
                List.of(3, 0, 1),
                List.of(2),
                List.of(0))));//Output: false
    }
}
