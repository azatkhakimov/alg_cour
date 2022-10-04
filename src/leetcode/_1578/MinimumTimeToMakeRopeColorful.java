package leetcode._1578;

//https://www.youtube.com/watch?v=wq6HX-LvIG4
public class MinimumTimeToMakeRopeColorful {
    public int minCost(String colors, int[] neededTime) {
        int start = 0;
        int end = 0;
        int n = colors.length();
        int totalTime = 0;
        while (start < n && end < n){
            int maxTime = 0;
            int groupTime = 0;
            while(end < n && colors.charAt(end) == colors.charAt(start)){
                maxTime = Math.max(maxTime, neededTime[end]);
                groupTime += neededTime[end];
                end++;
            }
            totalTime += (groupTime-maxTime);
            start = end;
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
