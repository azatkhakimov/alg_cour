package main.java.com.leetcode._1011;

public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int days) {
        int totalLoad = 0;
        int maxLoad = 0;
        for (int weight : weights) {
            totalLoad += weight;
            maxLoad = Math.max(maxLoad, weight);
        }
        int left = maxLoad;
        int right = totalLoad;
        while (left < right){
            int mid = left + (right-left)/2;
            if(feasible(weights, mid, days)){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return left;
    }

    private boolean feasible(int[] weights, int c, int days){
        int daysNeed = 1;
        int currentLoad = 0;
        for (int weight : weights) {
            currentLoad+=weight;
            if(currentLoad > c){
                daysNeed++;
                currentLoad = weight;
            }
        }
        return daysNeed <= days;
    }

    public static void main(String[] args) {
        CapacityToShipPackagesWithinDDays c = new CapacityToShipPackagesWithinDDays();
        System.out.println(c.shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9,10}, 5));//Output: 15
        System.out.println(c.shipWithinDays(new int[]{3,2,2,4,1,4}, 3));//Output: 6
        System.out.println(c.shipWithinDays(new int[]{1,2,3,1,1}, 4));//Output: 3
    }
}
