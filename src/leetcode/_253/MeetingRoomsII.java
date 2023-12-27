package leetcode._253;

import java.util.Arrays;

public class MeetingRoomsII {

    public int minMeetingRooms(int[][] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int needRooms = 0;
        for(int idxStart = 0, idxEnd = 0; idxStart < intervals.length; idxStart++){
            if(start[idxStart] < end[idxEnd]){
                needRooms++;
            }else {
                idxEnd++;
            }
        }
        return needRooms;
    }

    public static void main(String[] args) {
        var m = new MeetingRoomsII();
        System.out.println(m.minMeetingRooms(new int[][]{{0,30},{5,10},{15,20}}));//Output: 2
        System.out.println(m.minMeetingRooms(new int[][]{{7,10},{2,4}}));//Output: 1
    }
}
