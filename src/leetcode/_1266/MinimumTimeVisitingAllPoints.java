package leetcode._1266;

public class MinimumTimeVisitingAllPoints {


    public int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int currX = points[i][0];
            int currY = points[i][1];
            int targetX = points[i+1][0];
            int targetY = points[i+1][1];
            ans += Math.max(Math.abs(targetX-currX), Math.abs(targetY-currY));
        }
        return ans;
    }
    public static void main(String[] args) {
        var m = new MinimumTimeVisitingAllPoints();
        System.out.println(m.minTimeToVisitAllPoints(new int[][]{{1,1},{3,4},{-1,0}}));//Output: 7
        System.out.println(m.minTimeToVisitAllPoints(new int[][]{{3,2},{-2,2}}));//Output: 5
    }
}
