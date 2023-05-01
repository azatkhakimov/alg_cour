package leetcode._2187;

public class MinimumTimeToCompleteTrips {
    public long minimumTime(int[] time, int totalTrips) {
        int maxTime = 0;
        for (int t : time) {
            maxTime = Math.max(maxTime, t);
        }
        long left = 1;
        long right = (long)maxTime*totalTrips;

        while (left < right){
            long mid = left + (right-left)/2;
            if(timeEnough(time, mid, totalTrips)){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean timeEnough(int[] time, long givenTime, int totalTrips) {
        long actualTrips = 0;
        for (int t : time) {
            actualTrips += givenTime / t;
        }
        return actualTrips >= totalTrips;
    }

    public static void main(String[] args) {
        MinimumTimeToCompleteTrips m = new MinimumTimeToCompleteTrips();
        System.out.println(m.minimumTime(new int[]{1, 2, 3}, 5));//Output: 3
        System.out.println(m.minimumTime(new int[]{2}, 1));//Output: 2
    }
}
