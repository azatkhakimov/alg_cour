package main.java.com.leetcode._1232;

public class CheckIfItIsaStraightLine {

    public boolean checkStraightLine(int[][] coordinates) {
        int deltaY = getYDiff(coordinates[1], coordinates[0]);
        int deltaX = getXDiff(coordinates[1], coordinates[0]);

        for (int i = 2; i < coordinates.length; i++) {
            if(deltaY * getXDiff(coordinates[i], coordinates[0])
            != deltaX * getYDiff(coordinates[i], coordinates[0])){
                return false;
            }
        }
        return true;
    }

    private int getYDiff(int[] a, int[] b){
        return a[1] - b[1];
    }

    private int getXDiff(int[] a, int[] b){
        return a[0]-b[0];
    }

    public static void main(String[] args) {
        var c = new CheckIfItIsaStraightLine();
        System.out.println(c.checkStraightLine(new int[][]{
                {1,2},{2,3},{3,4},{4,5},{5,6},{6,7}
        }));//Output: true
        System.out.println(c.checkStraightLine(new int[][]{
                {1,1},{2,2},{3,4},{4,5},{5,6},{7,7}
        }));//Output: false
    }
}
