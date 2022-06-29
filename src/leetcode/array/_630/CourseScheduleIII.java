package leetcode.array._630;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CourseScheduleIII {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
        int time = 0;
        for (int[] cours : courses) {
            if(time + cours[0] <= cours[1]){
                queue.offer(cours[0]);
                time +=cours[0];
            }else if(!queue.isEmpty() && queue.peek() > cours[0]){
                time += cours[0] - queue.poll();
                queue.offer(cours[0]);
            }

        }
        return queue.size();
    }
    public static void main(String[] args) {
        CourseScheduleIII courseSchedule = new CourseScheduleIII();
        System.out.println(courseSchedule.scheduleCourse(new int[][]{{100,200},{200,1300}
                ,{1000,1250},{2000,3200}}));//Output: 3
    }
}
