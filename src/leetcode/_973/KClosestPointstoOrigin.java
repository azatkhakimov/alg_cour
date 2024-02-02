package leetcode._973;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointstoOrigin {


    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)-> distFromOrigin(b)-distFromOrigin(a));

        for (int i = 0; i < k; i++) {
            maxHeap.offer(points[i]);
        }
        for (int i = k; i < points.length; i++) {
            if(distFromOrigin(points[i]) < distFromOrigin(maxHeap.peek())){
                maxHeap.poll();
                maxHeap.offer(points[i]);
            }
        }

        return maxHeap.toArray(new int[0][0]);
    }

    private int distFromOrigin(int[] point){
        return point[0]*point[0] + point[1]*point[1];
    }


    public static void main(String[] args) {
        var k = new KClosestPointstoOrigin();
        System.out.println(Arrays.deepToString(k.kClosest(new int[][]{{1, 3}, {-2, 2}}, 1)));//Output: [[-2,2]]
        System.out.println(Arrays.deepToString(k.kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2)));//Output: [[3,3],[-2,4]]
    }
}
