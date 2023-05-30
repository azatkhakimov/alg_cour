package leetcode._1603;

import java.util.HashMap;
import java.util.Map;

public class ParkingSystem {

    int[] count;

    public ParkingSystem(int big, int medium, int small) {
        count = new int[]{big, medium, small};
    }

    public boolean addCar(int carType) {
        return count[carType-1]-- > 0;
    }
}
