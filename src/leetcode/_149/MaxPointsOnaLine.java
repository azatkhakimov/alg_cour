package leetcode._149;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnaLine {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n == 1) {
            return 1;
        }

        int result = 2;
        for (int i = 0; i < n; i++) {
            Map<Double, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    map.merge(Math.atan2(points[j][1] - points[i][1], points[j][0] - points[i][0]), 1, Integer::sum);
                }
            }
            result = Math.max(result, Collections.max(map.values()) + 1);
        }
        return result;
    }


    public static void main(String[] args) {
        MaxPointsOnaLine line = new MaxPointsOnaLine();
        System.out.println(line.maxPoints(new int[][]{{1, 1}, {2, 2}, {3, 3}}));//Output: 3
        System.out.println(line.maxPoints(new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}}));//Output: 4
    }
}
