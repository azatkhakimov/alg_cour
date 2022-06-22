package leetcode.array._1642;

import java.util.PriorityQueue;

public class FurthestBuildingYouCanReach {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < heights.length-1; i++) {
            int diff = heights[i+1]-heights[i];
            if(diff > 0){
                queue.add(diff);
            }
            if(queue.size() > ladders){
                bricks -= queue.poll();
            }
            if (bricks < 0){
                return i;
            }
        }
        return heights.length - 1;
    }

    public static void main(String[] args) {
        FurthestBuildingYouCanReach test = new FurthestBuildingYouCanReach();
        System.out.println(test.furthestBuilding(new int[]{4,2,7,6,9,14,12}, 5, 1));//Output: 4

    }
}
