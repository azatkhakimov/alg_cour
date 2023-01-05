package leetcode._1834;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SingleThreadedCPU {

    public int[] getOrder(int[][] tasks) {
        PriorityQueue<int[]> newTask = new PriorityQueue<>((a, b) -> (a[1] != b[1])
                ? (a[1] - b[1]) : (a[2] - b[2]));

        int[][] sortedTasks = new int[tasks.length][3];
        for (int i = 0; i < tasks.length; i++) {
            sortedTasks[i][0] = tasks[i][0];
            sortedTasks[i][1] = tasks[i][1];
            sortedTasks[i][2] = i;
        }
        Arrays.sort(sortedTasks, Comparator.comparingInt(a -> a[0]));
        int [] tasksProcOrder = new int[tasks.length];

        long curTime = 0;
        int taskIndex = 0;
        int ansIndex = 0;

        while (taskIndex < tasks.length || !newTask.isEmpty()){
            if(newTask.isEmpty() && curTime < sortedTasks[taskIndex][0]){
                curTime = sortedTasks[taskIndex][0];
            }

            while (taskIndex < tasks.length &&  curTime >= sortedTasks[taskIndex][0]){
                newTask.add(sortedTasks[taskIndex]);
                taskIndex++;
            }

            int processTime = newTask.peek()[1];
            int index = newTask.peek()[2];
            newTask.remove();

            curTime += processTime;
            tasksProcOrder[ansIndex++] = index;
        }
        return tasksProcOrder;
    }

    public static void main(String[] args) {
        SingleThreadedCPU cpu = new SingleThreadedCPU();
        System.out.println(Arrays.toString(cpu.getOrder(new int[][]{{1, 2}, {2, 4}, {3, 2}, {4, 1}})));//Output: [0,2,3,1]
        System.out.println(Arrays.toString(cpu.getOrder(new int[][]{{7, 10}, {7, 12}, {7, 5}, {7, 4}, {7, 2}})));//Output: [4,3,2,0,1]
    }
}
