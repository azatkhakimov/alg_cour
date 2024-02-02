package main.java.com.leetcode._1578;

//https://www.youtube.com/watch?v=wq6HX-LvIG4
public class MinimumTimeToMakeRopeColorful {
    public int minCost(String colors, int[] neededTime) {
       int left = 0;
       int right = 0;
       int totalTime = 0;
       while (left < neededTime.length && right < neededTime.length){
           int currTotal = 0;
           int currMax = 0;
           while (right < neededTime.length && colors.charAt(left) == colors.charAt(right)){
               currTotal += neededTime[right];
               currMax = Math.max(currMax, neededTime[right]);
               right++;
           }
           totalTime += currTotal - currMax;
           left = right;
       }
       return totalTime;
    }

    public static void main(String[] args) {
        MinimumTimeToMakeRopeColorful minimumTimeToMakeRopeColorful = new MinimumTimeToMakeRopeColorful();
        System.out.println(minimumTimeToMakeRopeColorful.minCost("abaac", new int[]{1,2,3,4,5}));//Output: 3
        System.out.println(minimumTimeToMakeRopeColorful.minCost("abc", new int[]{1,2,3}));//Output: 0
        System.out.println(minimumTimeToMakeRopeColorful.minCost("aabaa", new int[]{1,2,3,4,1}));//Output: 2
    }
}
