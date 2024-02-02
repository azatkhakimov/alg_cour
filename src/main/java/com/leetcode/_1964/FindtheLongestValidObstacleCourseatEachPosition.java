package main.java.com.leetcode._1964;

import java.util.Arrays;

public class FindtheLongestValidObstacleCourseatEachPosition {

    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        int lisLength = 0;
        int[] answer = new int[n];
        int[] lis = new int[n];
        for (int i = 0; i < n; i++) {
            int height = obstacles[i];
            int idx = bisectRights(lis, height, lisLength);
            if(idx == lisLength){
                lisLength++;
            }
            lis[idx] = height;
            answer[i] = idx+1;
        }
        return answer;

    }

    private int bisectRights(int[] a, int target, int right) {
        if(right == 0){
            return 0;
        }
        int left = 0;
        while (left < right){
            int mid = left + (right-left)/2;
            if(a[mid] <= target){
                left = mid+1;
            }
            else {
                right = mid;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        var f = new FindtheLongestValidObstacleCourseatEachPosition();
        System.out.println(Arrays.toString(f.
                longestObstacleCourseAtEachPosition(new int[]{1,2,3,2})));//Output: [1,2,3,3]
        System.out.println(Arrays.toString(f.
                longestObstacleCourseAtEachPosition(new int[]{2,2,1})));//Output: [1,2,1]
        System.out.println(Arrays.toString(f.
                longestObstacleCourseAtEachPosition(new int[]{3,1,5,6,4,2})));//Output: [1,1,2,3,2,2]
    }
}
