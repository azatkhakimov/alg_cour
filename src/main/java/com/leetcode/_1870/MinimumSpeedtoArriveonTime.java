package main.java.com.leetcode._1870;

public class MinimumSpeedtoArriveonTime {


    public int minSpeedOnTime(int[] dist, double hour) {
        int left = 1;
        int right = 10_000_000;
        int minSpeed = -1;
        while (left <= right){
            int mid = (left+right)/2;
            if(timeRequired(dist, mid) <= hour){
                minSpeed = mid;
                right = mid - 1;
            }else {
                left = mid+1;
            }
        }
        return minSpeed;
    }

    private double timeRequired(int[] dist, int speed) {
        double time = 0.0;
        for (int i = 0; i < dist.length; i++) {
            double t = (double)dist[i]/(double)speed;
            time += (i == dist.length - 1 ? t : Math.ceil(t));
        }
        return time;
    }

    public static void main(String[] args) {
        var m = new MinimumSpeedtoArriveonTime();
        System.out.println(m.minSpeedOnTime(new int[]{1,3,2}, 6));//Output: 1
        System.out.println(m.minSpeedOnTime(new int[]{1,3,2}, 2.7));//Output: 3
    }
}
