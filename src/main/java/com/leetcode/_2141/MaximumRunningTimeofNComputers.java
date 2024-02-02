package main.java.com.leetcode._2141;

public class MaximumRunningTimeofNComputers {

    public long maxRunTime(int n, int[] batteries) {
        long sumPower = 0;
        for (int power : batteries) {
            sumPower += power;
        }
        long left  =  1, right = sumPower / n;
        while (left < right){
            var target = right - (right - left)/2;
            long extra = 0;
            for (int power : batteries) {
                extra += Math.min(power, target);
            }
            if(extra >= (long)(n*target)){
                left = target;
            }else {
                right = target-1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        var m = new MaximumRunningTimeofNComputers();
        System.out.println(m.maxRunTime(2, new int[]{3,3,3}));//Output: 4
        System.out.println(m.maxRunTime(2, new int[]{1,1,1,1}));//Output: 2
    }
}
