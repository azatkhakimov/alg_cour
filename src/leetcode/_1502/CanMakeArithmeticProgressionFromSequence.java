package leetcode._1502;

import java.util.Arrays;

public class CanMakeArithmeticProgressionFromSequence {


    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if(arr[i] - arr[i-1] != diff){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        var c  = new CanMakeArithmeticProgressionFromSequence();
        System.out.println(c.canMakeArithmeticProgression(new int[]{3,5,1}));//Output: true
        System.out.println(c.canMakeArithmeticProgression(new int[]{1,2,4}));//Output: false
    }
}
