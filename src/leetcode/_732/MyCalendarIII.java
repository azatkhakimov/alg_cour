package leetcode._732;

public class MyCalendarIII {

    public static void main(String[] args) {
        MyCalendarThree myCalendarThree = new MyCalendarThree();
        System.out.println(myCalendarThree.book(10, 20));// return 1, The first event can be booked and is disjoint, so the maximum k-booking is a 1-booking.
        System.out.println(myCalendarThree.book(50, 60));//return 1, The second event can be booked and is disjoint, so the maximum k-booking is a 1-booking.
        System.out.println(myCalendarThree.book(10, 40));//return 2, The third event [10, 40) intersects the first event, and the maximum k-booking is a 2-booking.
        System.out.println(myCalendarThree.book(5, 15));//return 3, The remaining events cause the maximum K-booking to be only a 3-booking.
        System.out.println(myCalendarThree.book(5, 10));// return 3
        System.out.println(myCalendarThree.book(25, 55));//return 3
    }
}
