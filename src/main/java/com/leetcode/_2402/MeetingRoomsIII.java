package main.java.com.leetcode._2402;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsIII {

    public int mostBooked(int n, int[][] meetings) {
        int[] meetingCount = new int[n];
        var useRooms  = new PriorityQueue<long[]>((a,b)->a[0]!=b[0] ? Long.compare(a[0], b[0]) : Long.compare(a[1], b[1]));
        var unUsedRooms = new PriorityQueue<Integer>();
        for (int i = 0; i < n; i++) {
            unUsedRooms.offer(i);
        }

        Arrays.sort(meetings, (a,b)->a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];
            while (!useRooms.isEmpty() && useRooms.peek()[0] <= start) {
                int room = (int)useRooms.poll()[1];
                unUsedRooms.offer(room);
            }
            if(!unUsedRooms.isEmpty()){
                int room = unUsedRooms.poll();
                useRooms.offer(new long[]{end, room});
                meetingCount[room]++;
            }else {
                long roomAvailability = useRooms.peek()[0];
                int room = (int) useRooms.poll()[1];
                useRooms.offer(new long[]{roomAvailability+end-start, room});
                meetingCount[room]++;
            }
        }
        int maxMeetingCount = 0;
        int maxMeetingCountRoom = 0;
        for (int i = 0; i < n; i++) {
            if(meetingCount[i] > maxMeetingCount){
                maxMeetingCount = meetingCount[i];
                maxMeetingCountRoom = i;
            }
        }
        return maxMeetingCountRoom;
    }
    public static void main(String[] args) {
        var m = new MeetingRoomsIII();
        System.out.println(m.mostBooked(2,
                new int[][]{{0,10},{1,5},{2,7},{3,4}}));//Output: 0
        System.out.println(m.mostBooked(3,
                new int[][]{{1,20},{2,10},{3,5},{4,9},{6,8}}));//Output: 1
    }
}
