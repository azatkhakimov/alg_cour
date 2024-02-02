package main.java.com.leetcode._1732;

public class FindtheHighestAltitude {


    public int largestAltitude(int[] gain) {
        int currAltitude = 0;
        int maxAltitude = 0;

        for (int altitudeGain : gain) {
            currAltitude += altitudeGain;
            maxAltitude = Math.max(maxAltitude, currAltitude);
        }

        return maxAltitude;

    }

    public static void main(String[] args) {
        var f = new FindtheHighestAltitude();
        System.out.println(f.largestAltitude(new int[]{-5,1,5,0,-7}));//Output: 1
        System.out.println(f.largestAltitude(new int[]{-4,-3,-2,-1,4,3,2}));//Output: 0
    }
}
