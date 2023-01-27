package leetcode._881;

import java.util.Arrays;

public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0;
        int j = people.length-1;
        int ans = 0;
        while (i <= j){
            ans++;
            if(people[i]+people[j] <= limit){
                i++;
            }
            j--;
        }
        return ans;
    }


    public static void main(String[] args) {
        BoatsToSavePeople b = new BoatsToSavePeople();
        System.out.println(b.numRescueBoats(new int[]{1,2},  3));//Output: 1
        System.out.println(b.numRescueBoats(new int[]{3,2,2,1},  3));//Output: 3
        System.out.println(b.numRescueBoats(new int[]{3,5,3,4}, 5));//Output: 4
    }
}
