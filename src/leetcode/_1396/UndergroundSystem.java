package leetcode._1396;


import java.util.HashMap;
import java.util.Map;

public class UndergroundSystem {
    class Pair<T, R> {
        private T val1;
        private R val2;

        public Pair(T val1, R val2) {
            this.val1 = val1;
            this.val2 = val2;
        }

        public T getKey() {
            return val1;
        }

        public R getValue() {
            return val2;
        }
    }

    Map<Integer, Pair<String, Integer>> checkInMap;
    Map<String, Pair<Double, Integer>> routeMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        routeMap = new HashMap<>();

    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new Pair<>(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> checkIn = checkInMap.get(id);
        checkInMap.remove(id);
        String routeName = checkIn.getKey() + "_"+stationName;
        int totalTime = t - checkIn.getValue();
        Pair<Double, Integer> route = routeMap.getOrDefault(routeName, new Pair<>(0.0, 0));
        routeMap.put(routeName, new Pair<>(route.getKey()+totalTime, route.getValue()+1));
    }

    public double getAverageTime(String startStation, String endStation) {
        String routeName = startStation+"_"+endStation;
        Pair<Double, Integer> trip = routeMap.get(routeName);
        return trip.getKey() / trip.getValue();
    }
}
