package main.java.com.leetcode._1822;

public class SignoftheProductofanArray {


    public int arraySign(int[] nums) {
        int sign = 1;
        for (int num : nums) {
            if(num == 0){
                return 0;
            }
            if(num < 0){
                sign = -1 * sign;
            }
        }
        return sign;
    }



    public static void main(String[] args) {
        SignoftheProductofanArray s = new SignoftheProductofanArray();
        System.out.println(s.arraySign(new int[]{-1,-2,-3,-4,3,2,1}));//Output: 1
        System.out.println(s.arraySign(new int[]{1,5,0,2,-3}));//Output: 0
        System.out.println(s.arraySign(new int[]{-1,1,-1,1,-1}));//Output: -1
    }
}
