package leetcode._399;

import java.util.*;

public class EvaluateDivision {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            result[i] = getPathWeight(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>(), graph);
        }
        return result;
    }

    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        String u;
        String v;
        for (int i = 0; i < equations.size(); i++) {
            u = equations.get(i).get(0);
            v = equations.get(i).get(1);
            graph.putIfAbsent(u, new HashMap<>());
            graph.get(u).put(v, values[i]);
            graph.putIfAbsent(v, new HashMap<>());
            graph.get(v).put(u, 1 / values[i]);
        }
        return graph;
    }

    private double getPathWeight(String start, String end, HashSet<String> visited, Map<String, Map<String, Double>> graph) {
        if(!graph.containsKey(start)){
            return - 1.0;
        }
        if(graph.get(start).containsKey(end)){
            return graph.get(start).get(end);
        }
        visited.add(start);
        for (Map.Entry<String, Double> neighbour : graph.get(start).entrySet()) {
            if(!visited.contains(neighbour.getKey())){
                double productWeight = getPathWeight(neighbour.getKey(), end, visited, graph);
                if(productWeight != -1.0){
                    return neighbour.getValue() * productWeight;
                }
            }
        }
        return -1.0;
    }

    public static void main(String[] args) {
        var e = new EvaluateDivision();
        System.out.println(Arrays.toString(
                e.calcEquation(
                        Arrays.asList(Arrays.asList("a","b"), Arrays.asList("b","c")),
                        new double[]{2.0,3.0},
                        List.of(List.of("a","c"), List.of("b","a"), List.of("a","e"), List.of("a","a"), List.of("x","x"))
                )
        ));//Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
        System.out.println(Arrays.toString(
                e.calcEquation(
                        Arrays.asList(Arrays.asList("a","b"), Arrays.asList("b","c"), List.of("bc","cd")),
                        new double[]{1.5,2.5,5.0},
                        List.of(List.of("a","c"), List.of("c","b"), List.of("bc","cd"), List.of("cd","bc"))
                )
        ));//Output: [3.75000,0.40000,5.00000,0.20000]
        System.out.println(Arrays.toString(
                e.calcEquation(
                        Arrays.asList(Arrays.asList("a","b")),
                        new double[]{0.5},
                        List.of(List.of("a","b"), List.of("b","a"), List.of("a","c"), List.of("x","y"))
                )
        ));//[0.50000,2.00000,-1.00000,-1.00000]
    }
}
