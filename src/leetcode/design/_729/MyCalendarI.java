package leetcode.design._729;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MyCalendarI {
    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(10,20));//true
        System.out.println(myCalendar.book(15,25));//false;
        System.out.println(myCalendar.book(20, 30));//true;
    }

}

class MyCalendar {
    List<int[]> calendar;
    public MyCalendar() {
        calendar = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] ints : calendar) {
            if(ints[0] < end && start < ints[1]){
                return false;
            }
        }
        calendar.add(new int[]{start, end});
        return true;
    }
}


