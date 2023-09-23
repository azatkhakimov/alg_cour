package leetcode._332;

import java.util.*;

public class ReconstructItinerary {

    Map<String, PriorityQueue<String>> targets = new HashMap<>();
    List<String> route = new LinkedList();
    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            targets.computeIfAbsent(ticket.get(0), k->new PriorityQueue<>()).add(ticket.get(1));
        }
        visit("JFK");
        return route;
    }

    public void visit(String airport){
        while (targets.containsKey(airport) && !targets.get(airport).isEmpty()) {
            visit(targets.get(airport).poll());
        }
        route.add(0, airport);
    }

    public static void main(String[] args) {
        var r = new ReconstructItinerary();
        System.out.println(r.findItinerary(List.of(List.of("MUC", "LHR"),
                List.of("JFK", "MUC"), List.of("SFO", "SJC"), List.of("LHR", "SFO"))));//Output: ["JFK","MUC","LHR","SFO","SJC"]
        System.out.println(r.findItinerary(List.of(List.of("JFK", "SFO"), List.of("JFK", "ATL"), List.of("SFO", "ATL"),
                List.of("ATL", "JFK"), List.of("ATL", "SFO"))));//Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
    }
}
