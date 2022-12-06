package leetcode._452;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0){
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int arrPos = points[0][1];
        int count = 1;
        for (int i = 0; i < points.length; i++) {
            if(arrPos >= points[i][0]){
                continue;
            }
            count++;
            arrPos = points[i][1];
        }
        return count;
    }

    public static void main(String[] args) {
        MinimumNumberOfArrowsToBurstBalloons balloons = new MinimumNumberOfArrowsToBurstBalloons();
        System.out.println(balloons.findMinArrowShots(new int[][]{{10,16},{2,8},{1,6},{7,12}}));//Output: 2
        System.out.println(balloons.findMinArrowShots(new int[][]{{1,2},{3,4},{5,6},{7,8}}));//Output: 4
        System.out.println(balloons.findMinArrowShots(new int[][]{{1,2},{2,3},{3,4},{4,5}}));//Output: 2
    }
}
