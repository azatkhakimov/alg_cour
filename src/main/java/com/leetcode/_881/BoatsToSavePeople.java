package main.java.com.leetcode._881;

import java.util.Arrays;

public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length-1;
        int boats = 0;
        while (left <= right){
            int light = people[left];
            int heavy = people[right];
            if(light + heavy <= limit){
                left++;
                right--;
            }else {
                right--;
            }
            boats++;
        }
        return boats;
    }


    public static void main(String[] args) {
        BoatsToSavePeople b = new BoatsToSavePeople();
        System.out.println(b.numRescueBoats(new int[]{1,2},  3));//Output: 1
        System.out.println(b.numRescueBoats(new int[]{3,2,2,1},  3));//Output: 3
        System.out.println(b.numRescueBoats(new int[]{3,5,3,4}, 5));//Output: 4
    }
}
