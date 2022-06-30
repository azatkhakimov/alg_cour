package leetcode.graph;


import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0 || prerequisites == null || prerequisites.length == 0){
            return true;
        }
        List<List<Integer>> courses = new ArrayList<>(numCourses);
        for(int i = 0; i < numCourses; i++){
            courses.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++){
            courses.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++){
            if(!dfs(i, courses, visited)){
                return false;
            }
        }
        
        return true;
    }

    private boolean dfs(int course, List<List<Integer>> courses, int[] visited) {
        visited[course] = 1;
        List<Integer> eligibleCourses = courses.get(course);

        for(int i = 0; i < eligibleCourses.size(); i++){
            int eligibleCourse = eligibleCourses.get(i).intValue();
            if(visited[eligibleCourse]==1){
                return false;
            }
            if(visited[eligibleCourse] == 0){
                if(!dfs(eligibleCourse, courses, visited)){
                    return false;
                }
            }
        }
        visited[course] = 2;
        return true;
    }

    public static void main(String[] args) {
        CourseSchedule courseSchedule = new CourseSchedule();
        System.out.println(courseSchedule.canFinish(5, new int[][]{{0,1},{0,2}, {1,3},{1,4}, {3,4} }));
    }
}
