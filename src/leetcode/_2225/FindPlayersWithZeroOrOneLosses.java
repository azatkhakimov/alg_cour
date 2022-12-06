package leetcode._2225;

import java.util.*;

public class FindPlayersWithZeroOrOneLosses {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> losses = new TreeMap<>();
        for (int[] match : matches) {
            losses.put(match[0], losses.getOrDefault(match[0], 0));
            losses.put(match[1], losses.getOrDefault(match[1], 0)+1);
        }
        List<List<Integer>> res = Arrays.asList(new ArrayList<>(), new ArrayList<>());
        for (Integer player : losses.keySet()) {
            if(losses.get(player) <= 1){
                res.get(losses.get(player)).add(player);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindPlayersWithZeroOrOneLosses players = new FindPlayersWithZeroOrOneLosses();
        System.out.println(players.findWinners(new int[][]{{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}}));// Output: [[1,2,10],[4,5,7,8]));
        System.out.println(players.findWinners(new int[][]{{2, 3}, {1, 3}, {5, 4}, {6, 4}}));//Output: [[1,2,5,6],[]]

    }
}
