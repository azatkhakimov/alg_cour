package leetcode._2279;

import java.util.Arrays;

public class MaximumBagsWithFullCapacityOfRocks {

    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int fullBags = 0;

        int[] remainCapacity = new int[n];
        for (int i = 0; i < n; i++) {
            remainCapacity[i] = capacity[i]-rocks[i];
        }
        Arrays.sort(remainCapacity);

        for (int i = 0; i < n; i++) {
            if(additionalRocks >= remainCapacity[i]){
                additionalRocks -= remainCapacity[i];
                fullBags++;
            }
            else {
                break;
            }
        }
        return fullBags;
    }

    public static void main(String[] args) {
        MaximumBagsWithFullCapacityOfRocks bags = new MaximumBagsWithFullCapacityOfRocks();
        System.out.println(bags.maximumBags(new int[]{2,3,4,5},
                new int[]{1,2,4,4}, 2));//Output: 3
        System.out.println(bags.maximumBags(new int[]{10,2,2}, new int[]{2,2,0}, 100));//Output: 3
    }
}
