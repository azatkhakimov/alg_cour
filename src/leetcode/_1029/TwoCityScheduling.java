package leetcode._1029;

import java.util.Arrays;
import java.util.Comparator;

public class TwoCityScheduling {

    public int twoCitySchedCost(int[][] costs) {
        int totalCost = 0;
        Arrays.sort(costs, Comparator.comparingInt(a -> (a[0] - a[1])));

        int costLength = costs.length;
        for (int i = 0; i < costLength / 2; i++) {
            totalCost += costs[i][0] + costs[costLength-i-1][1];
        }
        return totalCost;
    }

    public static void main(String[] args) {
        var t = new TwoCityScheduling();
        System.out.println(t.twoCitySchedCost(new int[][]{{10, 20}, {30, 200}, {400, 50}, {30, 20}}));//Output: 110
        System.out.println(t.twoCitySchedCost(new int[][]{{259, 770}, {448, 54}, {926, 667}, {184, 139}, {840, 118}, {577, 469}}));//Output: 1859
        System.out.println(t.twoCitySchedCost(new int[][]{{515, 563}, {451, 713}, {537, 709}, {343, 819}, {855, 779}, {457, 60}, {650, 359}, {631, 42}}));//Output: 3086
    }
}
