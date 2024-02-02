package main.java.com.leetcode._1436;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DestinationCity {


    public String destCity(List<List<String>> paths) {
        Set<String> outgoing = new HashSet<>();
        for (List<String> path : paths) {
            outgoing.add(path.get(0));
        }

        for (List<String> path : paths) {
            String candidate = path.get(1);
            if(!outgoing.contains(candidate)){
                return candidate;
            }
        }
        return "";
    }
    public static void main(String[] args) {
        var d = new DestinationCity();
        System.out.println(d.destCity(List.of(
                List.of("London","New York"),
                List.of("New York","Lima"),
                List.of("Lima","Sao Paulo"))));//Output: "Sao Paulo"
        System.out.println(d.destCity(List.of(
                List.of("B","C"),
                List.of("D","B"),
                List.of("C","A")
        )));//Output: "A"
    }
}
