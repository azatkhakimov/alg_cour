package leetcode._1637;

import java.util.Arrays;
import java.util.Comparator;

public class WidestVerticalAreaBetweenTwoPointsContainingNoPoints {

    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));

        int ans = 0;
        for (int i = 1; i < points.length; i++) {
            ans = Math.max(ans, points[i][0]-points[i-1][0]);
        }
        return ans;
    }
    public static void main(String[] args) {
        var w = new WidestVerticalAreaBetweenTwoPointsContainingNoPoints();
        System.out.println(w.maxWidthOfVerticalArea(new int[][]{{8,7},{9,9},{7,4},{9,7}}));//Output: 1
        System.out.println(w.maxWidthOfVerticalArea(new int[][]{{3,1},{9,0},{1,0},{1,4}, {5,3},{8,8}}));//Output: 3
    }
}
