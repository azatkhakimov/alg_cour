package main.java.com.leetcode._1845;

import java.util.PriorityQueue;

public class SeatManager {
    private PriorityQueue<Integer> availableSeats;

    public SeatManager(int n) {
        availableSeats = new PriorityQueue<>();
        for (int seatNumber = 1; seatNumber <= n; seatNumber++) {
            availableSeats.offer(seatNumber);
        }
    }

    public int reserve() {
        return availableSeats.poll();
    }

    public void unreserve(int seatNumber) {
        availableSeats.offer(seatNumber);
    }
}
